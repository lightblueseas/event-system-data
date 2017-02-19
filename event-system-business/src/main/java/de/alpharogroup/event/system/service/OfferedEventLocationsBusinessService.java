package de.alpharogroup.event.system.service;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.OfferedEventLocationsDao;
import de.alpharogroup.event.system.entities.OfferedEventLocations;
import de.alpharogroup.event.system.service.api.OfferedEventLocationsService;
import de.alpharogroup.user.entities.Users;

@Transactional
@Service("offeredEventLocationsService")
public class OfferedEventLocationsBusinessService
		extends
		AbstractBusinessService<OfferedEventLocations, java.lang.Integer, OfferedEventLocationsDao>
		implements OfferedEventLocationsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setOfferedEventLocationsDao(
			OfferedEventLocationsDao offeredEventLocationsDao) {
		setDao(offeredEventLocationsDao);
	}
	
	@SuppressWarnings("unchecked")
	public List<OfferedEventLocations> findOfferedEventLocationsFromUser(Users user){
		String hqlString = "select distinct oel from OfferedEventLocations oel where oel.provider=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		final List<OfferedEventLocations> offeredEventLocations = query.getResultList();
		return offeredEventLocations;		
	}
	
	@SuppressWarnings("unchecked")	
	public  List<OfferedEventLocations> findOfferedEventLocationsFromZipcodeAndCity(String zipcode, String city) {
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct oel from OfferedEventLocations oel");
		if(StringUtils.isNotEmpty(zipcode) || StringUtils.isNotEmpty(city)) {
			sb.append(" where");
		}
		if(StringUtils.isNotEmpty(zipcode)) {
			sb.append(" oel.userAddress.zipcode.zipcode=:zipcode");
		}
		if(StringUtils.isNotEmpty(zipcode) && StringUtils.isNotEmpty(city)) {
			sb.append(" or");
		}
		if(StringUtils.isNotEmpty(city)) {
			sb.append(" oel.userAddress.zipcode.city=:city");
		}
		final Query query = getQuery(sb.toString());
		if(StringUtils.isNotEmpty(zipcode)) {
			query.setParameter("zipcode", zipcode);
		}
		if(StringUtils.isNotEmpty(city)) {
			query.setParameter("city", city);
		}
		final List<OfferedEventLocations> offeredEventLocations = query.getResultList();
		return offeredEventLocations;
	}


}