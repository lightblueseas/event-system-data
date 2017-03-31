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
package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.event.system.entities.EventRatings;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.entities.RatingDescriptions;
import de.alpharogroup.user.entities.Users;

public interface EventRatingsService extends BusinessService<EventRatings, java.lang.Integer> {
	/**
	 * Find all users that gave a rating from the given event.
	 * 
	 * @param event
	 *            the event
	 * @return the list
	 */
	List<Users> findAllUsersForRatedEvent(EventTemplates event);

	/**
	 * Find event ratings.
	 * 
	 * @param event
	 *            the event
	 * @return the list
	 */
	List<EventRatings> findEventRatings(final EventTemplates event);

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
	List<EventRatings> getEventRatingsForEvent(EventTemplates event);

	/**
	 * Gets the event ratings for event from subscriber.
	 * 
	 * @param event
	 *            the event
	 * @param subscriber
	 *            the subscriber
	 * @return the event ratings for event from subscriber
	 */
	List<EventRatings> getEventRatingsForEventFromSubscriber(EventTemplates event, Users subscriber);
}