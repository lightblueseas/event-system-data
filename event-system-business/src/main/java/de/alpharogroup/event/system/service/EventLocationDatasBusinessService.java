package de.alpharogroup.event.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.EventLocationDatasDao;
import de.alpharogroup.event.system.entities.EventLocationDatas;
import de.alpharogroup.event.system.service.api.EventLocationDatasService;

@Transactional
@Service("eventLocationDatasService")
public class EventLocationDatasBusinessService
		extends
		AbstractBusinessService<EventLocationDatas, java.lang.Integer, EventLocationDatasDao>
		implements EventLocationDatasService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventLocationDataDao(
			final EventLocationDatasDao eventLocationDataDao) {
		setDao(eventLocationDataDao);
	}



}