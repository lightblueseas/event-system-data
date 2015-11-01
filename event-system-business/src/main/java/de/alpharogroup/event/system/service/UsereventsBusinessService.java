package de.alpharogroup.event.system.service;

import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.entities.Userevents;
import de.alpharogroup.event.system.daos.UsereventsDao;
import de.alpharogroup.event.system.entities.EventTemplate;
import de.alpharogroup.event.system.enums.UsereventsRelationType;
import de.alpharogroup.event.system.service.api.UsereventsService;
import de.alpharogroup.user.management.entities.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("usereventsService")
public class UsereventsBusinessService extends
		AbstractBusinessService<Userevents, java.lang.Integer, UsereventsDao>
		implements UsereventsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUsereventsDao(UsereventsDao usereventsDao) {
		setDao(usereventsDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public Users findUser(final EventTemplate eventtemplateToFind,
			final UsereventsRelationType relationtype) {
		final String hqlString = "select ue.user from Userevents ue where ue.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", eventtemplateToFind);
		final List<Users> users = query.getResultList();
		return ListExtensions.getFirst(users);
	}

	@SuppressWarnings("unchecked")
	public List<Userevents> findUserevents(final EventTemplate event) {
		final String hqlString = "select ue from Userevents ue where ue.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		final List<Userevents> userevents = query.getResultList();
		return userevents;
	}


}