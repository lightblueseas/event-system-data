package de.alpharogroup.event.system.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.UserContactsAllowedContactmethodsDao;
import de.alpharogroup.event.system.entities.UserContactsAllowedContactmethods;
import de.alpharogroup.event.system.factories.DomainObjectFactory;
import de.alpharogroup.event.system.service.api.UserContactsAllowedContactmethodsService;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Users;

@Transactional
@Service("userContactsAllowedContactmethodsService")
public class UserContactsAllowedContactmethodsBusinessService
		extends
		AbstractBusinessService<UserContactsAllowedContactmethods, java.lang.Integer, UserContactsAllowedContactmethodsDao>
		implements UserContactsAllowedContactmethodsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUserContactsAllowedContactmethodsDao(
			UserContactsAllowedContactmethodsDao userContactsAllowedContactmethodsDao) {
		setDao(userContactsAllowedContactmethodsDao);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<UserContactsAllowedContactmethods> saveUserContactsAllowedContactmethods(
			final List<Contactmethods> userContactmethods,
			final Users userContact) {
		List<UserContactsAllowedContactmethods> userContactsAllowedContactmethods = new ArrayList<UserContactsAllowedContactmethods>();
		for (final Iterator<Contactmethods> iterator = userContactmethods
				.iterator(); iterator.hasNext();) {
			final Contactmethods userContactmethod = iterator.next();
			UserContactsAllowedContactmethods userContactsAllowedContactmethod = DomainObjectFactory
					.getInstance().getUserContactsAllowedContactmethods(
							userContact, userContactmethod);
			userContactsAllowedContactmethod = 
					merge(userContactsAllowedContactmethod);
			userContactsAllowedContactmethods
					.add(userContactsAllowedContactmethod);
		}
		return userContactsAllowedContactmethods;
	}

}