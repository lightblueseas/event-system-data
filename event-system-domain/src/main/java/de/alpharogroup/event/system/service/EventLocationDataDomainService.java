package de.alpharogroup.event.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.EventLocationDatasDao;
import de.alpharogroup.event.system.domain.EventLocationData;
import de.alpharogroup.event.system.entities.EventLocationDatas;
import de.alpharogroup.event.system.mapper.EventLocationDatasMapper;
import de.alpharogroup.event.system.service.api.EventLocationDataService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("eventLocationDataDomainService")
public class EventLocationDataDomainService
extends
AbstractDomainService<Integer,
EventLocationData,
EventLocationDatas,
EventLocationDatasDao,
EventLocationDatasMapper>
implements
EventLocationDataService
{
	/**
	 * Sets the specific {@link EventLocationDatasMapper}.
	 *
	 * @param mapper
	 *            the new {@link EventLocationDatasMapper}.
	 */
	@Autowired
	public void setEventLocationDatasMapper(EventLocationDatasMapper mapper) {
		setMapper(mapper);
	}


}
