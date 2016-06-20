package de.alpharogroup.event.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.EventTemplatesDao;
import de.alpharogroup.event.system.domain.EventTemplate;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.mapper.EventTemplatesMapper;
import de.alpharogroup.event.system.service.api.EventTemplateService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("eventTemplateDomainService")
public class EventTemplateDomainService
extends
AbstractDomainService<Integer,
EventTemplate,
EventTemplates,
EventTemplatesDao,
EventTemplatesMapper>
implements
EventTemplateService
{
	/**
	 * Sets the specific {@link EventTemplatesMapper}.
	 *
	 * @param mapper
	 *            the new {@link EventTemplatesMapper}.
	 */
	@Autowired
	public void setEventTemplatesMapper(EventTemplatesMapper mapper) {
		setMapper(mapper);
	}


}
