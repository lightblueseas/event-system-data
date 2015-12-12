package de.alpharogroup.event.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.RatingDescriptionsDao;
import de.alpharogroup.event.system.domain.RatingDescription;
import de.alpharogroup.event.system.entities.RatingDescriptions;
import de.alpharogroup.event.system.mapper.RatingDescriptionsMapper;
import de.alpharogroup.event.system.service.api.RatingDescriptionService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("ratingDescriptionDomainService")
public class RatingDescriptionDomainService
extends
AbstractDomainService<Integer,
RatingDescription,
RatingDescriptions,
RatingDescriptionsDao,
RatingDescriptionsMapper>
implements
RatingDescriptionService
{

}