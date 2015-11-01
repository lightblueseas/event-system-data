package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.event.system.entities.UserContactsAllowedContactmethods;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Users;

/**
 * The Interface UserContactsAllowedContactmethodsService.
 */
public interface UserContactsAllowedContactmethodsService extends
		BusinessService<UserContactsAllowedContactmethods, java.lang.Integer> {

	/**
	 * Saves for the given user the list from the given allowed contactmethods.
	 *
	 * @param userContactmethods the user contactmethods
	 * @param userContact the user contact
	 * @return the list
	 */
	List<UserContactsAllowedContactmethods> saveUserContactsAllowedContactmethods(
			List<Contactmethods> userContactmethods, Users userContact);
}