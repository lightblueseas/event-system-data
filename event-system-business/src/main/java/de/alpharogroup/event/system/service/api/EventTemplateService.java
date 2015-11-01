package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.entities.EventTemplate;
import de.alpharogroup.user.management.entities.Users;

public interface EventTemplateService extends
		BusinessService<EventTemplate, java.lang.Integer> {

	/**
	 * Delete event and all references.
	 *
	 * @param event            the event
	 * @return the event template
	 */
	public EventTemplate deleteEventAndAllReferences(final EventTemplate event);

	/**
	 * Find seminar.
	 *
	 * @param provider
	 *            the provider
	 * @param id
	 *            the id
	 * @return the seminars
	 */
	EventTemplate findEvent(final Users provider, final Integer id);

	/**
	 * Find seminars.
	 *
	 * @param eventname
	 *            the eventname
	 * @param category
	 *            the category
	 * @param condition
	 *            the condition
	 * @return the list
	 */
	List<EventTemplate> findEvents(final String eventname,
			final Categories category, final boolean condition);

	/**
	 * Find seminars.
	 *
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<EventTemplate> findEvents(final Users provider);
}