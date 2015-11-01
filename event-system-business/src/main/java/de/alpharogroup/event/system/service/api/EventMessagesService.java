package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.event.system.entities.EventMessages;
import de.alpharogroup.message.system.entities.Messages;
import de.alpharogroup.message.system.enums.MessageState;
import de.alpharogroup.user.management.entities.Users;

public interface EventMessagesService extends
		BusinessService<EventMessages, java.lang.Integer> {

	EventMessages findEventMessagesFromMessage(Messages message);

	EventMessages findEventMessagesFromEventLocation(EventLocations eventLocation);
	
	List<EventMessages> find(Messages message, EventLocations eventLocation);

	/**
	 * Find messages from the given user in the given state.
	 * 
	 * @param user
	 *            the user
	 * @param state
	 *            the state
	 * @return the list
	 */
	List<EventMessages> findMessages(Users user, MessageState state);

	/**
	 * Find all messages from the given provider.
	 * 
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<EventMessages> findMessages(final Users provider);
}