package de.alpharogroup.event.system.service;


import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.EventMessagesDao;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.event.system.entities.EventMessages;
import de.alpharogroup.event.system.service.api.EventMessagesService;
import de.alpharogroup.event.system.service.util.HqlStringCreator;
import de.alpharogroup.message.system.entities.Messages;
import de.alpharogroup.message.system.enums.MessageState;
import de.alpharogroup.user.management.entities.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("eventMessagesService")
public class EventMessagesBusinessService
		extends
		AbstractBusinessService<EventMessages, java.lang.Integer, EventMessagesDao>
		implements EventMessagesService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventMessagesDao(EventMessagesDao eventMessagesDao) {
		setDao(eventMessagesDao);
	}

	public EventMessages findEventMessagesFromMessage(final Messages message) {
		return ListExtensions.getFirst(find(message, null));
	}

	public EventMessages findEventMessagesFromEventLocation(
			final EventLocations eventLocation) {
		return ListExtensions.getFirst(find(null, eventLocation));
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventMessages> find(Messages message, EventLocations eventLocation) {
		String hqlString = HqlStringCreator.forEventMessages(message, eventLocation, EventMessages.class);				
		final Query query = getQuery(hqlString);
		if(message != null){
			query.setParameter("message", message);
		}
		if(eventLocation != null){
			query.setParameter("eventLocation", eventLocation);
		}
		final List<EventMessages> eventMessages = query.getResultList();
		return eventMessages;		
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventMessages> findMessages(final Users user, final MessageState state) {
		final String hqlString = "select distinct em "
				+ "from EventMessages as em join em.eventLocation as sem, "
				+ "Userevents as usev join usev.event as usem "
				+ "where sem.event.id=usem.id " + "and usev.user=:user "
				+ "and em.message.state=:state "
				+ "and em.message.deletedFlag=:deletedFlag";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		query.setParameter("state", state);
		query.setParameter("deletedFlag", Boolean.FALSE);
		final List<EventMessages> eventMessages = query.getResultList();
		return eventMessages;
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventMessages> findMessages(final Users provider) {
		final String hqlString = "select distinct em "
				+ "from EventMessages as em join em.eventLocation as sem, "
				+ "Userevents as usev join usev.event as usem  "
				+ "where sem.event.id= usem.id " + "and usev.user=:provider";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		final List<EventMessages> eventMessages = query.getResultList();
		return eventMessages;
	}

}