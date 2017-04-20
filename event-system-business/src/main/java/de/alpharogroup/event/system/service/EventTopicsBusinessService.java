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
import de.alpharogroup.event.system.daos.EventTopicsDao;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.entities.EventTopics;
import de.alpharogroup.event.system.entities.Topics;
import de.alpharogroup.event.system.service.api.EventTopicsService;

@Transactional
@Service("eventTopicsService")
public class EventTopicsBusinessService
	extends
		AbstractBusinessService<EventTopics, java.lang.Integer, EventTopicsDao>
	implements
		EventTopicsService
{

	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	public boolean contains(final Topics topic, final EventTemplates event)
	{
		return findEventTopic(topic, event) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public EventTopics findEventTopic(final Topics topic, final EventTemplates event)
	{
		final String hqlString = "select et from EventTopics et where et.event=:event and et.topic=:topic";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		query.setParameter("topic", topic);
		List<EventTopics> eventTopics = query.getResultList();
		return ListExtensions.getFirst(eventTopics);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventTopics> findEventTopics(final EventTemplates event)
	{
		final String hqlString = "select et from EventTopics et where et.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		List<EventTopics> eventTopics = query.getResultList();
		return eventTopics;
	}

	@Autowired
	public void setEventTopicsDao(EventTopicsDao eventTopicsDao)
	{
		setDao(eventTopicsDao);
	}

}