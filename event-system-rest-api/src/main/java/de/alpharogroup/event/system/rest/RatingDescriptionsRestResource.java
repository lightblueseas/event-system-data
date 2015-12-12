package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.RatingDescription;
import de.alpharogroup.event.system.rest.api.RatingDescriptionsResource;
import de.alpharogroup.event.system.service.api.RatingDescriptionService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class RatingDescriptionsRestResource
extends
AbstractRestfulResource<Integer, RatingDescription, RatingDescriptionService>
implements
RatingDescriptionsResource
{

}
