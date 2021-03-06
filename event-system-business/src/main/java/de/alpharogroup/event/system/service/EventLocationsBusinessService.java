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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.collections.list.ListExtensions;
import de.alpharogroup.date.CalculateDateExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.EventLocationsDao;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.enums.UsereventsRelationType;
import de.alpharogroup.event.system.service.api.EventLocationsService;
import de.alpharogroup.jgeohash.GeoHashExtensions;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.service.api.UserDatasService;

@Transactional
@Service("eventLocationsService")
public class EventLocationsBusinessService
	extends
		AbstractBusinessService<EventLocations, java.lang.Integer, EventLocationsDao>
	implements
		EventLocationsService
{

	private static final long serialVersionUID = 1L;
	/** The users business service. */
	@Autowired
	private UserDatasService userDataService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Users> findContactPersonsFromProvider(final Users provider)
	{
		final String hqlString = "select distinct el.contactperson from EventLocations el, Userevents ue "
			+ "where ue.user=:provider and el.event.id=ue.event.id";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		final List<Users> contactPersons = new ArrayList<>(
			new HashSet<Users>(query.getResultList()));
		return contactPersons;
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EventLocations findEvent(final Users provider, final EventTemplates event)
	{
		final String hqlString = "select el from EventLocations el, Userevents ue "
			+ " where ue.user=:provider" + " and ue.event=:event" + " and el.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		query.setParameter("event", event);
		final List<EventLocations> eventLocations = query.getResultList();
		return ListExtensions.getFirst(eventLocations);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEventLocations(final Addresses userAddress)
	{
		final String hqlString = "select ev from EventLocations ev where ev.eventLocation=:userAddress";
		final Query query = getQuery(hqlString);
		query.setParameter("userAddress", userAddress);
		final List<EventLocations> eventLocations = new ArrayList<>(
			new HashSet<EventLocations>(query.getResultList()));
		return eventLocations;
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEventLocations(final Users user,
		final UsereventsRelationType relationtype)
	{
		final String hqlString = "select distinct el from Userevents ue, EventLocations el "
			+ "where ue.user=:user " + "and ue.relationtype=:relationtype "
			+ "and el.event=ue.event";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		query.setParameter("relationtype", relationtype);
		final List<EventLocations> eventLocations = query.getResultList();
		return eventLocations;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEventLocationsFromEvent(final EventTemplates event)
	{
		final String hqlString = "select ev from EventLocations ev where ev.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		final List<EventLocations> eventLocations = new ArrayList<>(
			new HashSet<EventLocations>(query.getResultList()));
		return eventLocations;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Addresses> findEventLocationsFromProvider(final Users provider)
	{
		// String hqlString =
		// "select ev.eventLocation from EventLocations ev where
		// ev.event.provider=:provider";
		// final Query query = getQuery(hqlString);
		// query.setParameter("provider", provider);
		final UserDatas userData = userDataService.findBy(provider);
		final List<Addresses> userAdresses = new ArrayList<>(userData.getAddresses());
		return userAdresses;
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEvents(final EventTemplates event)
	{
		final String hqlString = "select distinct el from EventLocations el, Userevents ue "
			+ " where ue.event=:event " + " and el.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		final List<EventLocations> eventLocations = new ArrayList<>(
			new HashSet<EventLocations>(query.getResultList()));
		return eventLocations;
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEvents(final String eventname)
	{
		final StringBuilder sb = new StringBuilder();
		final Date systime = new Date();
		final Date start = CalculateDateExtensions.addDays(systime, 0);
		final Date end = CalculateDateExtensions.addDays(systime, 30);

		sb.append("select el from EventLocations el " + "where el.event.name like :eventname "
			+ "or el.event.head like :eventname "
			+ "and el.appointment.starttime between :start and :end");
		final String hqlString = sb.toString();
		final Query query = getQuery(hqlString);
		query.setParameter("eventname", "%" + eventname + "%");
		query.setParameter("start", start);
		query.setParameter("end", end);
		final List<EventLocations> result = query.getResultList();
		final List<EventLocations> foundEventLocations = new ArrayList<>(
			new HashSet<>(result));
		return foundEventLocations;
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEvents(final String eventname, final Categories category,
		final boolean condition)
	{
		final StringBuilder hqlString = new StringBuilder();
		if (null != category)
		{
			if (condition)
			{
				hqlString.append("select el from EventLocations el "
					+ "where el.event.name like :eventname " + "and el.event.categories=:category");
			}
			else
			{
				hqlString.append("select el from EventLocations el "
					+ "where el.event.name like :eventname " + "or el.event.categories=:category");
			}
		}
		else
		{
			hqlString
				.append("select el from EventLocations el where el.event.name like :eventname");
		}

		final Query query = getQuery(hqlString.toString());
		query.setParameter("eventname", eventname);
		if (null != category)
		{
			query.setParameter("category", category);
		}
		final List<EventLocations> foundEventLocations = new ArrayList<>(
			new HashSet<EventLocations>(query.getResultList()));
		return foundEventLocations;
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEvents(final String eventname, final Date start, final Date end,
		final String geohash)
	{
		Map<String, String> adjacentAreas = null;
		if (geohash != null && !geohash.isEmpty())
		{
			adjacentAreas = GeoHashExtensions.getAllAdjacentAreasMap(geohash);
		}
		else
		{
			return new ArrayList<>();
		}

		final StringBuilder hqlString = new StringBuilder();
		hqlString
			.append("select el from EventLocations el " + "where el.event.name like :eventname "
				+ "and el.appointment.starttime between :start and :end "
				+ "and el.userAddress.address.geohash in (" +
				// Subselect start...
				"select address.geohash from Addresses address "
				+ "where address.geohash like :top " + "or address.geohash like :topright "
				+ "or address.geohash like :right " + "or address.geohash like :bottomright "
				+ "or address.geohash like :bottom " + "or address.geohash like :bottomleft "
				+ "or address.geohash like :left " + "or address.geohash like :topleft "
				+ "or address.geohash like :center " +
				// Subselect end...
				")");
		final String queryString = hqlString.toString();
		final Query query = getQuery(queryString);
		query.setParameter("eventname", "%" + eventname + "%");
		query.setParameter("start", start);
		query.setParameter("end", end);
		for (final Entry<String, String> entry : adjacentAreas.entrySet())
		{
			query.setParameter(entry.getKey(), entry.getValue() + "%");
		}
		final List<EventLocations> foundEventLocations = new ArrayList<>(
			new HashSet<EventLocations>(query.getResultList()));
		return foundEventLocations;
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEvents(final Users provider)
	{
		final String hqlString = "select el from EventLocations el, Userevents ue "
			+ " where ue.user=:provider" + " and el.event.id=ue.event.id";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		final List<EventLocations> eventLocations = new ArrayList<>(
			new HashSet<EventLocations>(query.getResultList()));
		return eventLocations;
	}

	@Autowired
	public void setEventLocationsDao(EventLocationsDao eventLocationsDao)
	{
		setDao(eventLocationsDao);
	}

}