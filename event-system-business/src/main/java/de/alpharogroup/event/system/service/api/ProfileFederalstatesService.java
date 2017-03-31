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

import de.alpharogroup.address.book.entities.Federalstates;
import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.event.system.entities.ProfileFederalstates;
import de.alpharogroup.user.entities.Users;

/**
 * The Interface ProfileFederalstatesService.
 */
public interface ProfileFederalstatesService extends BusinessService<ProfileFederalstates, java.lang.Integer> {

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
	 * @param profileFederalstate
	 *            the profile federalstate
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
	ProfileFederalstates findProfileFederalstate(final Federalstates federalstate, final Users user);

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
	List<String> toStringList(final List<ProfileFederalstates> profileFederalstates);
}