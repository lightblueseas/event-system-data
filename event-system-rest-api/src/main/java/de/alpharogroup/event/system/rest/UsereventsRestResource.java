package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.Userevent;
import de.alpharogroup.event.system.rest.api.UsereventsResource;
import de.alpharogroup.event.system.service.api.UsereventService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class UsereventsRestResource
extends
AbstractRestfulResource<Integer, Userevent, UsereventService>
implements
UsereventsResource
{

}
