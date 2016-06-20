package de.alpharogroup.event.system.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.event.system.domain.EventTopic;
import de.alpharogroup.event.system.entities.EventTopics;

/**
 * The class {@link EventTopicsMapper}.
 */
@Component
public class EventTopicsMapper extends AbstractEntityDOMapper<EventTopics, EventTopic> {

}
