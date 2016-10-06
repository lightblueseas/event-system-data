package de.alpharogroup.event.system.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.event.system.domain.ProfileTopic;
import de.alpharogroup.event.system.entities.ProfileTopics;

/**
 * The class {@link ProfileTopicsMapper}.
 */
@Component
public class ProfileTopicsMapper extends AbstractEntityDOMapper<ProfileTopics, ProfileTopic> {

}
