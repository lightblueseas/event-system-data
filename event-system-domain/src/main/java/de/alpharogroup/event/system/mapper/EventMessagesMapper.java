package de.alpharogroup.event.system.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.event.system.domain.EventMessage;
import de.alpharogroup.event.system.entities.EventMessages;

/**
 * The class {@link EventMessagesMapper}.
 */
@Component
public class EventMessagesMapper extends AbstractEntityDOMapper<EventMessages, EventMessage> {

}
