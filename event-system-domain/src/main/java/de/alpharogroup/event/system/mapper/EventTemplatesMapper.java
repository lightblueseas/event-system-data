package de.alpharogroup.event.system.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.event.system.domain.EventTemplate;
import de.alpharogroup.event.system.entities.EventTemplates;

/**
 * The class {@link EventTemplatesMapper}.
 */
@Component
public class EventTemplatesMapper extends AbstractEntityDOMapper<EventTemplates, EventTemplate> {

}
