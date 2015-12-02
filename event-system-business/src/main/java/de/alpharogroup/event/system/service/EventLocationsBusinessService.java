package de.alpharogroup.event.system.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.date.CalculateDateExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.EventLocationsDao;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.event.system.entities.EventTemplate;
import de.alpharogroup.event.system.enums.UsereventsRelationType;
import de.alpharogroup.event.system.service.api.EventLocationsService;
import de.alpharogroup.jgeohash.GeoHashUtils;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.service.api.UserDatasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Autowired
	public void setEventLocationsDao(EventLocationsDao eventLocationsDao)
	{
		setDao(eventLocationsDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Users> findContactPersonsFromProvider(final Users provider)
	{
		final String hqlString = "select distinct el.contactperson from EventLocations el, Userevents ue "
			+ "where ue.user=:provider and el.event.id=ue.event.id";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		final List<Users> contactPersons = new ArrayList<Users>(new HashSet<Users>(
			query.getResultList()));
		return contactPersons;
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public EventLocations findEvent(final Users provider, final EventTemplate event)
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
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEventLocations(final Addresses userAddress)
	{
		final String hqlString = "select ev from EventLocations ev where ev.eventLocation=:userAddress";
		final Query query = getQuery(hqlString);
		query.setParameter("userAddress", userAddress);
		final List<EventLocations> eventLocations = new ArrayList<EventLocations>(
			new HashSet<EventLocations>(query.getResultList()));
		return eventLocations;
	}

	/**
	 * {@inheritDoc}.
	 */
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
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEventLocationsFromEvent(final EventTemplate event)
	{
		final String hqlString = "select ev from EventLocations ev where ev.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		final List<EventLocations> eventLocations = new ArrayList<EventLocations>(
			new HashSet<EventLocations>(query.getResultList()));
		return eventLocations;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Addresses> findEventLocationsFromProvider(final Users provider)
	{
		// String hqlString =
		// "select ev.eventLocation from EventLocations ev where ev.event.provider=:provider";
		// final Query query = getQuery(hqlString);
		// query.setParameter("provider", provider);
		final List<Addresses> userAdresses = new ArrayList<Addresses>(userDataService.get(
			provider.getUserData().getId()).getAddresses());
		return userAdresses;
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEvents(final EventTemplate event)
	{
		final String hqlString = "select distinct el from EventLocations el, Userevents ue "
			+ " where ue.event=:event " + " and el.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		final List<EventLocations> eventLocations = new ArrayList<EventLocations>(
			new HashSet<EventLocations>(query.getResultList()));
		return eventLocations;
	}

	/**
	 * {@inheritDoc}.
	 */
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
		final List<EventLocations> foundEventLocations = new ArrayList<EventLocations>(
			new HashSet<EventLocations>(query.getResultList()));
		return foundEventLocations;
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEvents(final String eventname)
	{
		final StringBuilder sb = new StringBuilder();
		Date systime = new Date();
		Date start = CalculateDateExtensions.addDays(systime, 0);
		Date end = CalculateDateExtensions.addDays(systime, 30);

		sb.append("select el from EventLocations el " + "where el.event.name like :eventname "
			+ "or el.event.head like :eventname "
			+ "and el.appointment.starttime between :start and :end");
		String hqlString = sb.toString();
		final Query query = getQuery(hqlString);
		query.setParameter("eventname", "%" + eventname + "%");
		query.setParameter("start", start);
		query.setParameter("end", end);
		List<EventLocations> result = query.getResultList();
		final List<EventLocations> foundEventLocations = new ArrayList<EventLocations>(
			new HashSet<EventLocations>(result));
		return foundEventLocations;
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEvents(final String eventname, final Date start,
		final Date end, final String geohash)
	{
		Map<String, String> adjacentAreas = null;
		if (geohash != null && !geohash.isEmpty())
		{
			adjacentAreas = GeoHashUtils.getAllAdjacentAreasMap(geohash);
		}
		else
		{
			return new ArrayList<EventLocations>();
		}

		final StringBuilder hqlString = new StringBuilder();
		hqlString.append("select el from EventLocations el "
			+ "where el.event.name like :eventname "
			+ "and el.appointment.starttime between :start and :end "
			+ "and el.userAddress.address.geohash in ("
			+
			// Subselect start...
			"select address.geohash from Addresses address " + "where address.geohash like :top "
			+ "or address.geohash like :topright " + "or address.geohash like :right "
			+ "or address.geohash like :bottomright " + "or address.geohash like :bottom "
			+ "or address.geohash like :bottomleft " + "or address.geohash like :left "
			+ "or address.geohash like :topleft " + "or address.geohash like :center " +
			// Subselect end...
			")");
		String queryString = hqlString.toString();
		final Query query = getQuery(queryString);
		query.setParameter("eventname", "%" + eventname + "%");
		query.setParameter("start", start);
		query.setParameter("end", end);
		for (Entry<String, String> entry : adjacentAreas.entrySet())
		{
			query.setParameter(entry.getKey(), entry.getValue() + "%");
		}
		final List<EventLocations> foundEventLocations = new ArrayList<EventLocations>(
			new HashSet<EventLocations>(query.getResultList()));
		return foundEventLocations;
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventLocations> findEvents(final Users provider)
	{
		final String hqlString = "select el from EventLocations el, Userevents ue "
			+ " where ue.user=:provider" + " and el.event.id=ue.event.id";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		final List<EventLocations> eventLocations = new ArrayList<EventLocations>(
			new HashSet<EventLocations>(query.getResultList()));
		return eventLocations;
	}

}