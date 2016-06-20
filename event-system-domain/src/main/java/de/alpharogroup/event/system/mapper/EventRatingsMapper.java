package de.alpharogroup.event.system.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.event.system.domain.EventRating;
import de.alpharogroup.event.system.entities.EventRatings;

/**
 * The class {@link EventRatingsMapper}.
 */
@Component
public class EventRatingsMapper extends AbstractEntityDOMapper<EventRatings, EventRating> {

}
