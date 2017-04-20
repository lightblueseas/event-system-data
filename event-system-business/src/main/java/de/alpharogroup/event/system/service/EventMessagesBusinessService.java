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
import de.alpharogroup.event.system.daos.EventMessagesDao;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.event.system.entities.EventMessages;
import de.alpharogroup.event.system.service.api.EventMessagesService;
import de.alpharogroup.event.system.service.util.HqlStringCreator;
import de.alpharogroup.message.system.entities.Messages;
import de.alpharogroup.message.system.enums.MessageState;
import de.alpharogroup.user.entities.Users;

@Transactional
@Service("eventMessagesService")
public class EventMessagesBusinessService
	extends
		AbstractBusinessService<EventMessages, java.lang.Integer, EventMessagesDao>
	implements
		EventMessagesService
{

	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventMessages> find(Messages message, EventLocations eventLocation)
	{
		String hqlString = HqlStringCreator.forEventMessages(message, eventLocation,
			EventMessages.class);
		final Query query = getQuery(hqlString);
		if (message != null)
		{
			query.setParameter("message", message);
		}
		if (eventLocation != null)
		{
			query.setParameter("eventLocation", eventLocation);
		}
		final List<EventMessages> eventMessages = query.getResultList();
		return eventMessages;
	}

	public EventMessages findEventMessagesFromEventLocation(final EventLocations eventLocation)
	{
		return ListExtensions.getFirst(find(null, eventLocation));
	}

	public EventMessages findEventMessagesFromMessage(final Messages message)
	{
		return ListExtensions.getFirst(find(message, null));
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventMessages> findMessages(final Users provider)
	{
		final String hqlString = "select distinct em "
			+ "from EventMessages as em join em.eventLocation as sem, "
			+ "Userevents as usev join usev.event as usem  " + "where sem.event.id= usem.id "
			+ "and usev.user=:provider";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		final List<EventMessages> eventMessages = query.getResultList();
		return eventMessages;
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventMessages> findMessages(final Users user, final MessageState state)
	{
		final String hqlString = "select distinct em "
			+ "from EventMessages as em join em.eventLocation as sem, "
			+ "Userevents as usev join usev.event as usem " + "where sem.event.id=usem.id "
			+ "and usev.user=:user " + "and em.message.state=:state "
			+ "and em.message.deletedFlag=:deletedFlag";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		query.setParameter("state", state);
		query.setParameter("deletedFlag", Boolean.FALSE);
		final List<EventMessages> eventMessages = query.getResultList();
		return eventMessages;
	}

	@Autowired
	public void setEventMessagesDao(EventMessagesDao eventMessagesDao)
	{
		setDao(eventMessagesDao);
	}

}