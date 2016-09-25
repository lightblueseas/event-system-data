package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.entities.Userevents;
import de.alpharogroup.event.system.enums.UsereventsRelationType;
import de.alpharogroup.user.management.entities.Users;

public interface UsereventsService extends
		BusinessService<Userevents, java.lang.Integer> {
	/**
	 * Find user.
	 * 
	 * @param eventtemplateToFind
	 *            the seminar to find
	 * @param relationtype
	 *            the relationtype
	 * @return the users
	 */
	Users findUser(final EventTemplates eventtemplateToFind,
			final UsereventsRelationType relationtype);

	List<Userevents> findUserevents(final EventTemplates event);
}