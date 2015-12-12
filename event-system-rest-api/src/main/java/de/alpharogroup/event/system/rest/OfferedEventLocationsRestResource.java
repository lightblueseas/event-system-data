package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.OfferedEventLocation;
import de.alpharogroup.event.system.rest.api.OfferedEventLocationsResource;
import de.alpharogroup.event.system.service.api.OfferedEventLocationService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class OfferedEventLocationsRestResource
extends
AbstractRestfulResource<Integer, OfferedEventLocation, OfferedEventLocationService>
implements
OfferedEventLocationsResource
{

}
