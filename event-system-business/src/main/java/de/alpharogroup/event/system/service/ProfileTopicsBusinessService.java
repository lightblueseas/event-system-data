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
import de.alpharogroup.event.system.daos.ProfileTopicsDao;
import de.alpharogroup.event.system.entities.ProfileTopics;
import de.alpharogroup.event.system.entities.Topics;
import de.alpharogroup.event.system.service.api.ProfileTopicsService;
import de.alpharogroup.user.entities.Users;

@Transactional
@Service("profileTopicsService")
public class ProfileTopicsBusinessService extends
		AbstractBusinessService<ProfileTopics, java.lang.Integer, ProfileTopicsDao> implements ProfileTopicsService {

	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}.
	 */
	public boolean contains(final Topics topic, final Users user) {
		return findProfileTopic(topic, user) != null;
	}

	/**
	 * {@inheritDoc}.
	 */
	public void deleteWithAllReferences(ProfileTopics profileTopics) {
		if (profileTopics != null) {
			profileTopics.setUser(null);
			profileTopics.setTopic(null);
			profileTopics = merge(profileTopics);
			delete(profileTopics);
		}
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public ProfileTopics findProfileTopic(final Topics topic, final Users user) {
		final String hqlString = "select pt from ProfileTopics pt where pt.user=:user and pt.topic=:topic";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		query.setParameter("topic", topic);
		List<ProfileTopics> profileTopics = query.getResultList();
		return ListExtensions.getFirst(profileTopics);
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<ProfileTopics> findProfileTopics(final Users user) {
		final String hqlString = "select pt from ProfileTopics pt where pt.user=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		List<ProfileTopics> profileTopics = query.getResultList();
		return profileTopics;
	}

	@Autowired
	public void setProfileTopicsDao(ProfileTopicsDao profileTopicsDao) {
		setDao(profileTopicsDao);
	}

}