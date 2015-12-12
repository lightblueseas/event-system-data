package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.Topic;
import de.alpharogroup.event.system.rest.api.TopicsResource;
import de.alpharogroup.event.system.service.api.TopicService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class TopicsRestResource
extends
AbstractRestfulResource<Integer, Topic, TopicService>
implements
TopicsResource
{

}
