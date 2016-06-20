package de.alpharogroup.event.system.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.event.system.domain.Topic;
import de.alpharogroup.event.system.entities.Topics;

/**
 * The class {@link TopicsMapper}.
 */
@Component
public class TopicsMapper extends AbstractEntityDOMapper<Topics, Topic> {

}
