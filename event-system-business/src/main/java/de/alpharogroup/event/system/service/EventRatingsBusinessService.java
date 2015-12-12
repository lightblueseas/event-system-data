package de.alpharogroup.event.system.service;

import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.EventRatingsDao;
import de.alpharogroup.event.system.entities.EventRatings;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.entities.RatingDescriptions;
import de.alpharogroup.event.system.service.api.EventRatingsService;
import de.alpharogroup.rating.system.enums.RatingVisibility;
import de.alpharogroup.user.management.entities.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("eventRatingsService")
public class EventRatingsBusinessService
		extends
		AbstractBusinessService<EventRatings, java.lang.Integer, EventRatingsDao>
		implements EventRatingsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventRatingsDao(EventRatingsDao eventRatingsDao) {
		setDao(eventRatingsDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Users> findAllUsersForRatedEvent(final EventTemplates event) {
		final String hqlString = "select distinct er.rater from EventRatings er where er.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		List<Users> foundUsers = query.getResultList();
		return foundUsers;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventRatings> findEventRatings(final EventTemplates event) {
		final String hqlString = "select er from EventRatings er where er.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventRatings> findEventRatings(final Users subscriber) {
		final String hqlString = "select er from EventRatings er where er.rater=:rater";
		final Query query = getQuery(hqlString);
		query.setParameter("rater", subscriber);
		List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventRatings> findRatedEvents(final Users provider) {
		final String hqlString = "select er from EventRatings er "
				+ "where er.event.provider=:provider "
				+ "and er.visibility=:visibility";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		query.setParameter("visibility", RatingVisibility.INVISIBLE);
		List<EventRatings> eventRatings = query.getResultList();
		return eventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public RatingDescriptions findRatingDescription(
			final EventRatings eventRating) {
		final String hqlString = "select rd from RatingDescriptions rd where rd.eventRatings=:eventRating";
		final Query query = getQuery(hqlString);
		query.setParameter("eventRating", eventRating);
		List<RatingDescriptions> ratingDescriptions = query.getResultList();

		return ListExtensions.getFirst(ratingDescriptions);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventRatings> getEventRatingsForEvent(final EventTemplates event) {
		final String hqlString = "select distinct er from EventRatings er where er.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventRatings> getEventRatingsForEventFromSubscriber(
			final EventTemplates event, final Users subscriber) {
		final String hqlString = "select distinct er from EventRatings er where er.event=:event and er.rater=:subscriber";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		query.setParameter("subscriber", subscriber);
		List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

}