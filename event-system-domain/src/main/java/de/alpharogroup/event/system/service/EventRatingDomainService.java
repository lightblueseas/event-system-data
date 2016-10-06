package de.alpharogroup.event.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.EventRatingsDao;
import de.alpharogroup.event.system.domain.EventRating;
import de.alpharogroup.event.system.entities.EventRatings;
import de.alpharogroup.event.system.mapper.EventRatingsMapper;
import de.alpharogroup.event.system.service.api.EventRatingService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("eventRatingDomainService")
public class EventRatingDomainService
extends
AbstractDomainService<Integer,
EventRating,
EventRatings,
EventRatingsDao,
EventRatingsMapper>
implements
EventRatingService
{
	/**
	 * Sets the specific {@link EventRatingsMapper}.
	 *
	 * @param mapper
	 *            the new {@link EventRatingsMapper}.
	 */
	@Autowired
	public void setEventRatingsMapper(EventRatingsMapper mapper) {
		setMapper(mapper);
	}


}
