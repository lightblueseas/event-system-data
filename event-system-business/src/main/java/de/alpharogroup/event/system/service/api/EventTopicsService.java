package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.entities.EventTopics;
import de.alpharogroup.event.system.entities.Topics;

public interface EventTopicsService extends
		BusinessService<EventTopics, java.lang.Integer> {	

	/**
	 * Contains.
	 * 
	 * @param topic
	 *            the topic
	 * @param event
	 *            the event
	 * @return true, if successful
	 */
	boolean contains(final Topics topic, final EventTemplates event);

	/**
	 * Find event topic.
	 * 
	 * @param topic
	 *            the topic
	 * @param event
	 *            the event
	 * @return the event topics
	 */
	EventTopics findEventTopic(final Topics topic, final EventTemplates event);

	/**
	 * Find event topics.
	 * 
	 * @param event
	 *            the event
	 * @return the list
	 */
	List<EventTopics> findEventTopics(final EventTemplates event);
}