package de.alpharogroup.event.system.service.api;

import java.util.Date;
import java.util.List;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.enums.UsereventsRelationType;
import de.alpharogroup.user.management.entities.Users;

public interface EventLocationsService extends
		BusinessService<EventLocations, java.lang.Integer> {
	

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
	 * @param category
	 *            the category
	 * @param condition
	 *            the condition
	 * @return the list
	 */
	List<EventLocations> findEvents(final String eventname,
			final Categories category, final boolean condition);

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
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @param geohash
	 *            the geohash for range. The geohash should be a substring from
	 *            the search address geohash to limit the range from the search.
	 * @return the list
	 */
	List<EventLocations> findEvents(final String eventname, final Date start,
			final Date end, final String geohash);

	/**
	 * Find events.
	 *
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<EventLocations> findEvents(final Users provider);

	/**
	 * Find event locations from provider.
	 *
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<Addresses> findEventLocationsFromProvider(final Users provider);

	/**
	 * Find all contact persons from the given provider.
	 *
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<Users> findContactPersonsFromProvider(final Users provider);

	/**
	 * Find all event locations from given event.
	 *
	 * @param event
	 *            the event
	 * @return the list
	 */
	public List<EventLocations> findEventLocationsFromEvent(EventTemplates event);

	/**
	 * Find event locations where the given user address is in use.
	 *
	 * @param userAddress
	 *            the user address
	 * @return the list
	 */
	public List<EventLocations> findEventLocations(Addresses userAddress);

}