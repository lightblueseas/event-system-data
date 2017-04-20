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
package de.alpharogroup.event.system.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.address.book.entities.Countries;
import de.alpharogroup.address.book.entities.Federalstates;
import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.ProfileFederalstatesDao;
import de.alpharogroup.event.system.entities.ProfileFederalstates;
import de.alpharogroup.event.system.service.api.ProfileFederalstatesService;
import de.alpharogroup.user.entities.Users;

@Transactional
@Service("profileFederalstatesService")
public class ProfileFederalstatesBusinessService
	extends
		AbstractBusinessService<ProfileFederalstates, java.lang.Integer, ProfileFederalstatesDao>
	implements
		ProfileFederalstatesService
{

	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	public boolean contains(final Federalstates federalstate, final Users user)
	{
		return findProfileFederalstate(federalstate, user) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteWithAllReferences(ProfileFederalstates profileFederalstate)
	{
		profileFederalstate.setUser(null);
		profileFederalstate.setFederalstate(null);
		profileFederalstate = merge(profileFederalstate);
		delete(profileFederalstate);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public ProfileFederalstates findProfileFederalstate(final Federalstates federalstate,
		final Users user)
	{
		final String hqlString = "select pf from ProfileFederalstates pf where pf.user=:user and pf.federalstate=:federalstate";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		query.setParameter("federalstate", federalstate);
		List<ProfileFederalstates> profileFederalstates = query.getResultList();
		return ListExtensions.getFirst(profileFederalstates);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "unchecked" })
	public List<ProfileFederalstates> findProfileFederalstates(final Users user)
	{
		final String hqlString = "select pf from ProfileFederalstates pf where pf.user=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		List<ProfileFederalstates> profileFederalstates = query.getResultList();
		return profileFederalstates;
	}

	@Autowired
	public void setProfileFederalstatesDao(ProfileFederalstatesDao profileFederalstatesDao)
	{
		setDao(profileFederalstatesDao);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> toStringList(final List<ProfileFederalstates> profileFederalstates)
	{
		List<String> selectedFederalstates = new ArrayList<String>();
		for (ProfileFederalstates profileFederalstate : profileFederalstates)
		{
			Federalstates federalstate = profileFederalstate.getFederalstate();
			if (federalstate != null)
			{
				Countries country = federalstate.getCountry();
				String result;
				if (country == null)
				{
					String federalstateName = federalstate.getName();
					result = federalstateName;
				}
				else
				{
					String splitString = "=>";
					String countryName = country.getName();
					String iso3166A2code = federalstate.getIso3166A2code();
					result = countryName + splitString + iso3166A2code;
				}
				selectedFederalstates.add(result);
			}
		}
		return selectedFederalstates;
	}

}