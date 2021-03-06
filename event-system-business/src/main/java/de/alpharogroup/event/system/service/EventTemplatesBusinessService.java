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
import java.util.HashSet;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.collections.list.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.EventTemplatesDao;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.event.system.entities.EventRatings;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.entities.EventTopics;
import de.alpharogroup.event.system.entities.RatingDescriptions;
import de.alpharogroup.event.system.entities.Userevents;
import de.alpharogroup.event.system.service.api.EventLocationsService;
import de.alpharogroup.event.system.service.api.EventMessagesService;
import de.alpharogroup.event.system.service.api.EventRatingsService;
import de.alpharogroup.event.system.service.api.EventTemplatesService;
import de.alpharogroup.event.system.service.api.EventTopicsService;
import de.alpharogroup.event.system.service.api.RatingDescriptionsService;
import de.alpharogroup.event.system.service.api.UsereventsService;
import de.alpharogroup.scheduler.system.entities.Appointments;
import de.alpharogroup.scheduler.system.service.api.AppointmentsService;
import de.alpharogroup.user.entities.Users;

@Transactional
@Service("eventTemplatesService")
public class EventTemplatesBusinessService
	extends
		AbstractBusinessService<EventTemplates, java.lang.Integer, EventTemplatesDao>
	implements
		EventTemplatesService
{

	private static final long serialVersionUID = 1L;
	/** The Constant logger. */
	private static final Logger logger = Logger
		.getLogger(EventTemplatesBusinessService.class.getName());

	/** The event locations business service. */
	@Autowired
	private EventLocationsService eventLocationsService;

	/** The event topics business service. */
	@Autowired
	private EventTopicsService eventTopicsService;

	/** The appointments business service. */
	@Autowired
	private AppointmentsService appointmentsService;

	@Autowired
	private EventRatingsService eventRatingsService;
	@Autowired
	private RatingDescriptionsService ratingDescriptionsService;
	@Autowired
	private UsereventsService userEventsService;
	@Autowired
	private EventMessagesService eventMessagesService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EventTemplates deleteEventAndAllReferences(final EventTemplates event)
	{

		event.setCategories(null);
		merge(event);

		final List<EventLocations> eventLocations = eventLocationsService.findEvents(event);
		// find all event_topics and delete it...
		final List<EventTopics> eventTopics = eventTopicsService.findEventTopics(event);
		// find all event_ratings and delete it...
		final List<EventRatings> eventRatings = eventRatingsService.findEventRatings(event);
		// delete all related ratings from the event_ratings...
		final List<Userevents> userevents = userEventsService.findUserevents(event);

		// delete all references from event_topics...
		if (!ListExtensions.isEmpty(eventTopics))
		{
			for (EventTopics eventTopic : eventTopics)
			{
				eventTopic.setTopic(null);
				eventTopic.setEvent(null);
				eventTopic = eventTopicsService.merge(eventTopic);
				eventTopicsService.delete(eventTopic);
			}
		}

		if (!ListExtensions.isEmpty(userevents))
		{
			for (Userevents userevent : userevents)
			{
				userevent.setEvent(null);
				userevent.setUser(null);
				userevent = userEventsService.merge(userevent);
				userEventsService.delete(userevent);
			}
		}
		if (!ListExtensions.isEmpty(eventRatings))
		{
			for (EventRatings eventRating : eventRatings)
			{
				// Get related RatingDescriptions if exists...
				RatingDescriptions rd = eventRatingsService.findRatingDescription(eventRating);
				if (rd != null)
				{
					rd.setEventRatings(null);
					rd = ratingDescriptionsService.merge(rd);
					ratingDescriptionsService.delete(rd);
				}
				eventRating.setEvent(null);
				eventRating.setRater(null);
				eventRating = eventRatingsService.merge(eventRating);
				eventRatingsService.delete(eventRating);
			}
		}

		// delete all references from event_locations...
		if (!ListExtensions.isEmpty(eventLocations))
		{
			for (EventLocations eventLocation : eventLocations)
			{
				if (eventMessagesService.findEventMessagesFromEventLocation(eventLocation) != null)
				{
					// delete only...
					eventLocation.setAppointment(null);
					eventLocation.setEvent(null);
					eventLocation.setEventLocation(null);
					continue;
				}

				if (eventLocation.getAppointment() != null)
				{
					final Appointments appointment = eventLocation.getAppointment();
					eventLocation.setAppointment(null);
					eventLocation.setEvent(null);
					eventLocation.setEventLocation(null);
					eventLocation.setContactperson(null);
					eventLocation = eventLocationsService.merge(eventLocation);
					if (appointment != null)
					{
						appointmentsService.delete(appointment);
					}
					eventLocation = eventLocationsService.merge(eventLocation);
					eventLocationsService.delete(eventLocation);
				}
			}
		}
		final Integer id = event.getId();
		if (exists(id))
		{
			try
			{
				this.delete(event);
			}
			catch (final Exception e)
			{
				if (event != null && event.getId() != null)
				{
					logger
						.info("Exception thrown by tryin delete an event with id:" + event.getId());
					logger.info(e.getMessage());
				}
				return event;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EventTemplates findEvent(final Users provider, final Integer id)
	{
		final String hqlString = "select s from Events as s where s.provider=:provider and s.id=:id";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		query.setParameter("id", id);
		final List<EventTemplates> events = new ArrayList<>(
			new HashSet<EventTemplates>(query.getResultList()));
		return ListExtensions.getFirst(events);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventTemplates> findEvents(final String eventname, final Categories category,
		final boolean condition)
	{
		final StringBuilder hqlString = new StringBuilder();
		if (null != category)
		{
			if (condition)
			{
				hqlString.append(
					"select s from Events as s where s.name like :eventname and s.categories.name=':category'");
			}
			else
			{
				hqlString.append(
					"select s from Events as s where s.name like :eventname or s.categories.name=':category'");
			}
		}
		else
		{
			hqlString.append("select s from Events as s where s.name like :eventname");
		}

		final Query query = getQuery(hqlString.toString());
		query.setParameter("eventname", eventname);
		if (null != category)
		{
			query.setParameter("category", category);
		}
		final List<EventTemplates> foundEvents = query.getResultList();
		return foundEvents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventTemplates> findEvents(final Users provider)
	{
		final String hqlString = "select distinct ue.event from Userevents ue"
			+ " where ue.user=:provider" + " and ue.relationtype='PROVIDED'";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		final List<EventTemplates> events = new ArrayList<>(
			new HashSet<EventTemplates>(query.getResultList()));
		return events;
	}

	@Autowired
	public void setEventTemplateDao(final EventTemplatesDao eventTemplateDao)
	{
		setDao(eventTemplateDao);
	}

}