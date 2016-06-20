package de.alpharogroup.event.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.ProfileTopicsDao;
import de.alpharogroup.event.system.domain.ProfileTopic;
import de.alpharogroup.event.system.entities.ProfileTopics;
import de.alpharogroup.event.system.mapper.ProfileTopicsMapper;
import de.alpharogroup.event.system.service.api.ProfileTopicService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("profileTopicDomainService")
public class ProfileTopicDomainService
extends
AbstractDomainService<Integer,
ProfileTopic,
ProfileTopics,
ProfileTopicsDao,
ProfileTopicsMapper>
implements
ProfileTopicService
{
	/**
	 * Sets the specific {@link ProfileTopicsMapper}.
	 *
	 * @param mapper
	 *            the new {@link ProfileTopicsMapper}.
	 */
	@Autowired
	public void setProfileTopicsMapper(ProfileTopicsMapper mapper) {
		setMapper(mapper);
	}


}
