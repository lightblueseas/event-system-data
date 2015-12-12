package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.EventRating;
import de.alpharogroup.event.system.rest.api.EventRatingsResource;
import de.alpharogroup.event.system.service.api.EventRatingService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class EventRatingsRestResource
extends
AbstractRestfulResource<Integer, EventRating, EventRatingService>
implements
EventRatingsResource
{

}
