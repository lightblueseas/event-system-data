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

import de.alpharogroup.collections.list.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.EventRatingsDao;
import de.alpharogroup.event.system.entities.EventRatings;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.entities.RatingDescriptions;
import de.alpharogroup.event.system.service.api.EventRatingsService;
import de.alpharogroup.rating.system.enums.RatingVisibility;
import de.alpharogroup.user.entities.Users;

@Transactional
@Service("eventRatingsService")
public class EventRatingsBusinessService
	extends
		AbstractBusinessService<EventRatings, java.lang.Integer, EventRatingsDao>
	implements
		EventRatingsService
{

	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Users> findAllUsersForRatedEvent(final EventTemplates event)
	{
		final String hqlString = "select distinct er.rater from EventRatings er where er.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		final List<Users> foundUsers = query.getResultList();
		return foundUsers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventRatings> findEventRatings(final EventTemplates event)
	{
		final String hqlString = "select er from EventRatings er where er.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		final List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventRatings> findEventRatings(final Users subscriber)
	{
		final String hqlString = "select er from EventRatings er where er.rater=:rater";
		final Query query = getQuery(hqlString);
		query.setParameter("rater", subscriber);
		final List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventRatings> findRatedEvents(final Users provider)
	{
		final String hqlString = "select er from EventRatings er "
			+ "where er.event.provider=:provider " + "and er.visibility=:visibility";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		query.setParameter("visibility", RatingVisibility.INVISIBLE);
		final List<EventRatings> eventRatings = query.getResultList();
		return eventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public RatingDescriptions findRatingDescription(final EventRatings eventRating)
	{
		final String hqlString = "select rd from RatingDescriptions rd where rd.eventRatings=:eventRating";
		final Query query = getQuery(hqlString);
		query.setParameter("eventRating", eventRating);
		final List<RatingDescriptions> ratingDescriptions = query.getResultList();

		return ListExtensions.getFirst(ratingDescriptions);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventRatings> getEventRatingsForEvent(final EventTemplates event)
	{
		final String hqlString = "select distinct er from EventRatings er where er.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		final List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventRatings> getEventRatingsForEventFromSubscriber(final EventTemplates event,
		final Users subscriber)
	{
		final String hqlString = "select distinct er from EventRatings er where er.event=:event and er.rater=:subscriber";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		query.setParameter("subscriber", subscriber);
		final List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

	@Autowired
	public void setEventRatingsDao(EventRatingsDao eventRatingsDao)
	{
		setDao(eventRatingsDao);
	}

}