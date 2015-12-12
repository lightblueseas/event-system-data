package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.EventTemplate;
import de.alpharogroup.event.system.rest.api.EventTemplatesResource;
import de.alpharogroup.event.system.service.api.EventTemplateService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class EventTemplatesRestResource
extends
AbstractRestfulResource<Integer, EventTemplate, EventTemplateService>
implements
EventTemplatesResource
{

}
