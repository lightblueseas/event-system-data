package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.EventTopic;
import de.alpharogroup.event.system.rest.api.EventTopicsResource;
import de.alpharogroup.event.system.service.api.EventTopicService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class EventTopicsRestResource
extends
AbstractRestfulResource<Integer, EventTopic, EventTopicService>
implements
EventTopicsResource
{

}
