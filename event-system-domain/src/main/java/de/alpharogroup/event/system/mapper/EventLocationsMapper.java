package de.alpharogroup.event.system.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.event.system.domain.EventLocation;
import de.alpharogroup.event.system.entities.EventLocations;

/**
 * The class {@link EventLocationsMapper}.
 */
@Component
public class EventLocationsMapper extends AbstractEntityDOMapper<EventLocations, EventLocation> {

}
