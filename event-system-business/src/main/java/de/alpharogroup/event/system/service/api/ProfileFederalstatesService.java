package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.address.book.entities.Federalstates;
import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.event.system.entities.ProfileFederalstates;
import de.alpharogroup.user.management.entities.Users;

/**
 * The Interface ProfileFederalstatesService.
 */
public interface ProfileFederalstatesService extends
		BusinessService<ProfileFederalstates, java.lang.Integer> {

	/**
	 * Contains.
	 * 
	 * @param federalstate
	 *            the federalstate
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	boolean contains(final Federalstates federalstate, final Users user);

	/**
	 * Delete with all references.
	 *
	 * @param profileFederalstate the profile federalstate
	 */
	void deleteWithAllReferences(ProfileFederalstates profileFederalstate);

	/**
	 * Find profile federalstate.
	 * 
	 * @param federalstate
	 *            the federalstate
	 * @param user
	 *            the user
	 * @return the profile federalstates
	 */
	ProfileFederalstates findProfileFederalstate(
			final Federalstates federalstate, final Users user);

	/**
	 * Find profile federalstates.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<ProfileFederalstates> findProfileFederalstates(final Users user);

	/**
	 * Converts the given ProfileFederalstates list to a string list needed from
	 * the view.
	 * 
	 * @param profileFederalstates
	 *            the profile federalstates
	 * @return the list
	 */
	List<String> toStringList(
			final List<ProfileFederalstates> profileFederalstates);
}