package de.alpharogroup.event.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.OfferedEventLocationsDao;
import de.alpharogroup.event.system.domain.OfferedEventLocation;
import de.alpharogroup.event.system.entities.OfferedEventLocations;
import de.alpharogroup.event.system.mapper.OfferedEventLocationsMapper;
import de.alpharogroup.event.system.service.api.OfferedEventLocationService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("offeredEventLocationDomainService")
public class OfferedEventLocationDomainService
extends
AbstractDomainService<Integer,
OfferedEventLocation,
OfferedEventLocations,
OfferedEventLocationsDao,
OfferedEventLocationsMapper>
implements
OfferedEventLocationService
{

}
