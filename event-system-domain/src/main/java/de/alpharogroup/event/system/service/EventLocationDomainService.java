package de.alpharogroup.event.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.EventLocationsDao;
import de.alpharogroup.event.system.domain.EventLocation;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.event.system.mapper.EventLocationsMapper;
import de.alpharogroup.event.system.service.api.EventLocationService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("eventLocationDomainService")
public class EventLocationDomainService
extends
AbstractDomainService<Integer,
EventLocation,
EventLocations,
EventLocationsDao,
EventLocationsMapper>
implements
EventLocationService
{

}
