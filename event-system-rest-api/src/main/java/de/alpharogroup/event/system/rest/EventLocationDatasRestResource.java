package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.EventLocationData;
import de.alpharogroup.event.system.rest.api.EventLocationDatasResource;
import de.alpharogroup.event.system.service.api.EventLocationDataService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class EventLocationDatasRestResource
extends
AbstractRestfulResource<Integer, EventLocationData, EventLocationDataService>
implements
EventLocationDatasResource
{

}
