package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.EventLocation;
import de.alpharogroup.event.system.rest.api.EventLocationsResource;
import de.alpharogroup.event.system.service.api.EventLocationService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class EventLocationsRestResource
extends
AbstractRestfulResource<Integer, EventLocation, EventLocationService>
implements
EventLocationsResource
{

}
