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
import de.alpharogroup.user.management.entities.Users;

@Transactional
@Service("profileFederalstatesService")
public class ProfileFederalstatesBusinessService
		extends
		AbstractBusinessService<ProfileFederalstates, java.lang.Integer, ProfileFederalstatesDao>
		implements ProfileFederalstatesService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setProfileFederalstatesDao(
			ProfileFederalstatesDao profileFederalstatesDao) {
		setDao(profileFederalstatesDao);
	}	

	/**
	 * {@inheritDoc}
	 */
	public boolean contains(final Federalstates federalstate, final Users user) {
		return findProfileFederalstate(federalstate, user) != null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void deleteWithAllReferences(ProfileFederalstates profileFederalstate) {
		profileFederalstate.setUser(null);
		profileFederalstate.setFederalstate(null);
		profileFederalstate = merge(profileFederalstate);
		delete(profileFederalstate);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public ProfileFederalstates findProfileFederalstate(
			final Federalstates federalstate, final Users user) {
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
	public List<ProfileFederalstates> findProfileFederalstates(final Users user) {
		final String hqlString = "select pf from ProfileFederalstates pf where pf.user=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		List<ProfileFederalstates> profileFederalstates = query.getResultList();
		return profileFederalstates;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> toStringList(
			final List<ProfileFederalstates> profileFederalstates) {
		List<String> selectedFederalstates = new ArrayList<String>();
		for (ProfileFederalstates profileFederalstate : profileFederalstates) {
			Federalstates federalstate = profileFederalstate.getFederalstate();
			if (federalstate != null) {
				Countries country = federalstate.getCountry();
				String result;
				if (country == null) {
					String federalstateName = federalstate.getName();
					result = federalstateName;
				} else {
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