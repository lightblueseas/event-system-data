package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.event.system.entities.ProfileTopics;
import de.alpharogroup.event.system.entities.Topics;
import de.alpharogroup.user.management.entities.Users;

/**
 * The Interface ProfileTopicsService.
 */
public interface ProfileTopicsService extends
		BusinessService<ProfileTopics, java.lang.Integer> {
	/**
	 * Contains.
	 * 
	 * @param topic
	 *            the topic
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	boolean contains(final Topics topic, final Users user);

	/**
	 * Delete with all references.
	 *
	 * @param profileTopics the profile topics
	 */
	void deleteWithAllReferences(ProfileTopics profileTopics);

	/**
	 * Find profile topic.
	 * 
	 * @param topic
	 *            the topic
	 * @param user
	 *            the user
	 * @return the profile topics
	 */
	ProfileTopics findProfileTopic(final Topics topic, final Users user);

	/**
	 * Find profile topics.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<ProfileTopics> findProfileTopics(final Users user);
}