package de.alpharogroup.event.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.EventMessagesDao;
import de.alpharogroup.event.system.domain.EventMessage;
import de.alpharogroup.event.system.entities.EventMessages;
import de.alpharogroup.event.system.mapper.EventMessagesMapper;
import de.alpharogroup.event.system.service.api.EventMessageService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("eventMessageDomainService")
public class EventMessageDomainService
extends
AbstractDomainService<Integer,
EventMessage,
EventMessages,
EventMessagesDao,
EventMessagesMapper>
implements
EventMessageService
{

	/**
	 * Sets the specific {@link EventMessagesMapper}.
	 *
	 * @param mapper
	 *            the new {@link EventMessagesMapper}.
	 */
	@Autowired
	public void setEventMessagesMapper(EventMessagesMapper mapper) {
		setMapper(mapper);
	}

}
