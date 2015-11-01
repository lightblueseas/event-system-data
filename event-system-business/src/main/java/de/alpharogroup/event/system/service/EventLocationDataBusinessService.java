package de.alpharogroup.event.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.EventLocationDataDao;
import de.alpharogroup.event.system.entities.EventLocationData;
import de.alpharogroup.event.system.service.api.EventLocationDataService;

@Transactional
@Service("eventLocationDataService")
public class EventLocationDataBusinessService
		extends
		AbstractBusinessService<EventLocationData, java.lang.Integer, EventLocationDataDao>
		implements EventLocationDataService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventLocationDataDao(
			EventLocationDataDao eventLocationDataDao) {
		setDao(eventLocationDataDao);
	}



}