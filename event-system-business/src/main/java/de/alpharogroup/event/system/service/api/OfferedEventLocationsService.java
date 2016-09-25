package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.event.system.entities.OfferedEventLocations;
import de.alpharogroup.user.management.entities.Users;

public interface OfferedEventLocationsService extends
		BusinessService<OfferedEventLocations, java.lang.Integer> {

	
	List<OfferedEventLocations> findOfferedEventLocationsFromUser(Users user);
	
	List<OfferedEventLocations> findOfferedEventLocationsFromZipcodeAndCity(String zipcode, String city);
}