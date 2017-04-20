/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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
	implements
		OfferedEventLocationsService
{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<OfferedEventLocations> findOfferedEventLocationsFromUser(Users user)
	{
		String hqlString = "select distinct oel from OfferedEventLocations oel where oel.provider=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		final List<OfferedEventLocations> offeredEventLocations = query.getResultList();
		return offeredEventLocations;
	}

	@SuppressWarnings("unchecked")
	public List<OfferedEventLocations> findOfferedEventLocationsFromZipcodeAndCity(String zipcode,
		String city)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct oel from OfferedEventLocations oel");
		if (StringUtils.isNotEmpty(zipcode) || StringUtils.isNotEmpty(city))
		{
			sb.append(" where");
		}
		if (StringUtils.isNotEmpty(zipcode))
		{
			sb.append(" oel.userAddress.zipcode.zipcode=:zipcode");
		}
		if (StringUtils.isNotEmpty(zipcode) && StringUtils.isNotEmpty(city))
		{
			sb.append(" or");
		}
		if (StringUtils.isNotEmpty(city))
		{
			sb.append(" oel.userAddress.zipcode.city=:city");
		}
		final Query query = getQuery(sb.toString());
		if (StringUtils.isNotEmpty(zipcode))
		{
			query.setParameter("zipcode", zipcode);
		}
		if (StringUtils.isNotEmpty(city))
		{
			query.setParameter("city", city);
		}
		final List<OfferedEventLocations> offeredEventLocations = query.getResultList();
		return offeredEventLocations;
	}

	@Autowired
	public void setOfferedEventLocationsDao(OfferedEventLocationsDao offeredEventLocationsDao)
	{
		setDao(offeredEventLocationsDao);
	}

}