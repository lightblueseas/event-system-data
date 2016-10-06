package de.alpharogroup.event.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.EventTopicsDao;
import de.alpharogroup.event.system.domain.EventTopic;
import de.alpharogroup.event.system.entities.EventTopics;
import de.alpharogroup.event.system.mapper.EventTopicsMapper;
import de.alpharogroup.event.system.service.api.EventTopicService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("eventTopicDomainService")
public class EventTopicDomainService
extends
AbstractDomainService<Integer,
EventTopic,
EventTopics,
EventTopicsDao,
EventTopicsMapper>
implements
EventTopicService
{

	/**
	 * Sets the specific {@link EventTopicsMapper}.
	 *
	 * @param mapper
	 *            the new {@link EventTopicsMapper}.
	 */
	@Autowired
	public void setEventTopicsMapper(EventTopicsMapper mapper) {
		setMapper(mapper);
	}

}
