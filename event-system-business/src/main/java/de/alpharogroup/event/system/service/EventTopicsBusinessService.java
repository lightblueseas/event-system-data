package de.alpharogroup.event.system.service;

import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.EventTopicsDao;
import de.alpharogroup.event.system.entities.EventTemplate;
import de.alpharogroup.event.system.entities.EventTopics;
import de.alpharogroup.event.system.entities.Topics;
import de.alpharogroup.event.system.service.api.EventTopicsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("eventTopicsService")
public class EventTopicsBusinessService extends
		AbstractBusinessService<EventTopics, java.lang.Integer, EventTopicsDao>
		implements EventTopicsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventTopicsDao(EventTopicsDao eventTopicsDao) {
		setDao(eventTopicsDao);
	}


	/**
	 * {@inheritDoc}
	 */
	public boolean contains(final Topics topic, final EventTemplate event) {
		return findEventTopic(topic, event) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public EventTopics findEventTopic(final Topics topic, final EventTemplate event) {
		final String hqlString = "select et from EventTopics et where et.event=:event and et.topic=:topic";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		query.setParameter("topic", topic);
		List<EventTopics> eventTopics = query.getResultList();
		return ListExtensions.getFirst(eventTopics);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventTopics> findEventTopics(final EventTemplate event) {
		final String hqlString = "select et from EventTopics et where et.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		List<EventTopics> eventTopics = query.getResultList();
		return eventTopics;
	}


}