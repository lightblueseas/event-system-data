package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.user.management.entities.Users;

public interface EventTemplatesService extends
		BusinessService<EventTemplates, java.lang.Integer> {

	/**
	 * Delete event and all references.
	 *
	 * @param event            the event
	 * @return the event template
	 */
	public EventTemplates deleteEventAndAllReferences(final EventTemplates event);

	/**
	 * Find seminar.
	 *
	 * @param provider
	 *            the provider
	 * @param id
	 *            the id
	 * @return the seminars
	 */
	EventTemplates findEvent(final Users provider, final Integer id);

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
	List<EventTemplates> findEvents(final String eventname,
			final Categories category, final boolean condition);

	/**
	 * Find seminars.
	 *
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<EventTemplates> findEvents(final Users provider);
}