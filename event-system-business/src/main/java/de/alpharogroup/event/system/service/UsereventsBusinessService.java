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

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.UsereventsDao;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.entities.Userevents;
import de.alpharogroup.event.system.enums.UsereventsRelationType;
import de.alpharogroup.event.system.service.api.UsereventsService;
import de.alpharogroup.user.entities.Users;

@Transactional
@Service("usereventsService")
public class UsereventsBusinessService extends AbstractBusinessService<Userevents, java.lang.Integer, UsereventsDao>
		implements UsereventsService {

	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public Users findUser(final EventTemplates eventtemplateToFind, final UsereventsRelationType relationtype) {
		final String hqlString = "select ue.user from Userevents ue where ue.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", eventtemplateToFind);
		final List<Users> users = query.getResultList();
		return ListExtensions.getFirst(users);
	}

	@SuppressWarnings("unchecked")
	public List<Userevents> findUserevents(final EventTemplates event) {
		final String hqlString = "select ue from Userevents ue where ue.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		final List<Userevents> userevents = query.getResultList();
		return userevents;
	}

	@Autowired
	public void setUsereventsDao(UsereventsDao usereventsDao) {
		setDao(usereventsDao);
	}

}