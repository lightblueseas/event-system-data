package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.event.system.entities.EventRatings;
import de.alpharogroup.event.system.entities.EventTemplate;
import de.alpharogroup.event.system.entities.RatingDescriptions;
import de.alpharogroup.user.management.entities.Users;

public interface EventRatingsService extends
		BusinessService<EventRatings, java.lang.Integer> {
	/**
	 * Find all users that gave a rating from the given event.
	 * 
	 * @param event
	 *            the event
	 * @return the list
	 */
	List<Users> findAllUsersForRatedEvent(EventTemplate event);

	/**
	 * Find event ratings.
	 * 
	 * @param event
	 *            the event
	 * @return the list
	 */
	List<EventRatings> findEventRatings(final EventTemplate event);

	/**
	 * Finds the events that was rated from the given subscriber.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<EventRatings> findEventRatings(Users user);

	/**
	 * Finds the events from the given provider that was rated from the
	 * subscribers.
	 * 
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<EventRatings> findRatedEvents(Users provider);

	/**
	 * Find rating description from the given EventRatings.
	 * 
	 * @param eventRating
	 *            the event rating
	 * @return the rating descriptions or null if it doesn't exists.
	 */
	RatingDescriptions findRatingDescription(final EventRatings eventRating);

	/**
	 * Gets the event ratings for event.
	 * 
	 * @param event
	 *            the event
	 * @return the event ratings for event
	 */
	List<EventRatings> getEventRatingsForEvent(EventTemplate event);

	/**
	 * Gets the event ratings for event from subscriber.
	 * 
	 * @param event
	 *            the event
	 * @param subscriber
	 *            the subscriber
	 * @return the event ratings for event from subscriber
	 */
	List<EventRatings> getEventRatingsForEventFromSubscriber(EventTemplate event,
			Users subscriber);
}