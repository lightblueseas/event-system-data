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

import java.util.Date;
import java.util.List;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.enums.UsereventsRelationType;
import de.alpharogroup.user.entities.Users;

public interface EventLocationsService extends BusinessService<EventLocations, java.lang.Integer>
{

	/**
	 * Find all contact persons from the given provider.
	 *
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<Users> findContactPersonsFromProvider(final Users provider);

	/**
	 * Find events.
	 *
	 * @param provider
	 *            the provider
	 * @param event
	 *            the event
	 * @return the event locations
	 */
	EventLocations findEvent(final Users provider, final EventTemplates event);

	/**
	 * Find event locations where the given user address is in use.
	 *
	 * @param userAddress
	 *            the user address
	 * @return the list
	 */
	public List<EventLocations> findEventLocations(Addresses userAddress);

	/**
	 * Find event locations.
	 *
	 * @param user
	 *            the user
	 * @param relationtype
	 *            the relationtype
	 * @return the list
	 */
	List<EventLocations> findEventLocations(final Users user,
		final UsereventsRelationType relationtype);

	/**
	 * Find all event locations from given event.
	 *
	 * @param event
	 *            the event
	 * @return the list
	 */
	public List<EventLocations> findEventLocationsFromEvent(EventTemplates event);

	/**
	 * Find event locations from provider.
	 *
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<Addresses> findEventLocationsFromProvider(final Users provider);

	/**
	 * Find events.
	 *
	 * @param event
	 *            the event
	 * @return the list
	 */
	List<EventLocations> findEvents(final EventTemplates event);

	/**
	 * Find events.
	 *
	 * @param eventname
	 *            the eventname
	 * @return the list
	 */
	List<EventLocations> findEvents(final String eventname);

	/**
	 * Find events.
	 *
	 * @param eventname
	 *            the eventname
	 * @param category
	 *            the category
	 * @param condition
	 *            the condition
	 * @return the list
	 */
	List<EventLocations> findEvents(final String eventname, final Categories category,
		final boolean condition);

	/**
	 * Find events.
	 *
	 * @param eventname
	 *            the eventname
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @param geohash
	 *            the geohash for range. The geohash should be a substring from the search address
	 *            geohash to limit the range from the search.
	 * @return the list
	 */
	List<EventLocations> findEvents(final String eventname, final Date start, final Date end,
		final String geohash);

	/**
	 * Find events.
	 *
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<EventLocations> findEvents(final Users provider);

}