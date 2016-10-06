package de.alpharogroup.event.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.TopicsDao;
import de.alpharogroup.event.system.domain.Topic;
import de.alpharogroup.event.system.entities.Topics;
import de.alpharogroup.event.system.mapper.TopicsMapper;
import de.alpharogroup.event.system.service.api.TopicService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("topicDomainService")
public class TopicDomainService
extends
AbstractDomainService<Integer,
Topic,
Topics,
TopicsDao,
TopicsMapper>
implements
TopicService
{
	/**
	 * Sets the specific {@link TopicsMapper}.
	 *
	 * @param mapper
	 *            the new {@link TopicsMapper}.
	 */
	@Autowired
	public void setTopicsMapper(TopicsMapper mapper) {
		setMapper(mapper);
	}


}
