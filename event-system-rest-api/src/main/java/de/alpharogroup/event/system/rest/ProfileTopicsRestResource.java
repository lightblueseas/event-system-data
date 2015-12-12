package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.ProfileTopic;
import de.alpharogroup.event.system.rest.api.ProfileTopicsResource;
import de.alpharogroup.event.system.service.api.ProfileTopicService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class ProfileTopicsRestResource
extends
AbstractRestfulResource<Integer, ProfileTopic, ProfileTopicService>
implements
ProfileTopicsResource
{

}
