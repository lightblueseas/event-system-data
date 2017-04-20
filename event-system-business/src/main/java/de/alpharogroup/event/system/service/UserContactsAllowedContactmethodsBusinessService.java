/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.event.system.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.UserContactsAllowedContactmethodsDao;
import de.alpharogroup.event.system.entities.UserContactsAllowedContactmethods;
import de.alpharogroup.event.system.factories.DomainObjectFactory;
import de.alpharogroup.event.system.service.api.UserContactsAllowedContactmethodsService;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.entities.Contactmethods;

@Transactional
@Service("userContactsAllowedContactmethodsService")
public class UserContactsAllowedContactmethodsBusinessService
	extends
		AbstractBusinessService<UserContactsAllowedContactmethods, java.lang.Integer, UserContactsAllowedContactmethodsDao>
	implements
		UserContactsAllowedContactmethodsService
{

	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	public List<UserContactsAllowedContactmethods> saveUserContactsAllowedContactmethods(
		final List<Contactmethods> userContactmethods, final Users userContact)
	{
		List<UserContactsAllowedContactmethods> userContactsAllowedContactmethods = new ArrayList<UserContactsAllowedContactmethods>();
		for (final Iterator<Contactmethods> iterator = userContactmethods.iterator(); iterator
			.hasNext();)
		{
			final Contactmethods userContactmethod = iterator.next();
			UserContactsAllowedContactmethods userContactsAllowedContactmethod = DomainObjectFactory
				.getInstance().getUserContactsAllowedContactmethods(userContact, userContactmethod);
			userContactsAllowedContactmethod = merge(userContactsAllowedContactmethod);
			userContactsAllowedContactmethods.add(userContactsAllowedContactmethod);
		}
		return userContactsAllowedContactmethods;
	}

	@Autowired
	public void setUserContactsAllowedContactmethodsDao(
		UserContactsAllowedContactmethodsDao userContactsAllowedContactmethodsDao)
	{
		setDao(userContactsAllowedContactmethodsDao);
	}

}