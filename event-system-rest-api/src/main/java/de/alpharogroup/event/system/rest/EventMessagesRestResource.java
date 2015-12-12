package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.EventMessage;
import de.alpharogroup.event.system.rest.api.EventMessagesResource;
import de.alpharogroup.event.system.service.api.EventMessageService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class EventMessagesRestResource
extends
AbstractRestfulResource<Integer, EventMessage, EventMessageService>
implements
EventMessagesResource
{

}
