package de.alpharogroup.event.system.service;

import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.RatingDescriptionsDao;
import de.alpharogroup.event.system.entities.EventRatings;
import de.alpharogroup.event.system.entities.RatingDescriptions;
import de.alpharogroup.event.system.service.api.RatingDescriptionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("ratingDescriptionsService")
public class RatingDescriptionsBusinessService
		extends
		AbstractBusinessService<RatingDescriptions, java.lang.Integer, RatingDescriptionsDao>
		implements RatingDescriptionsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setRatingDescriptionsDao(
			RatingDescriptionsDao ratingDescriptionsDao) {
		setDao(ratingDescriptionsDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public RatingDescriptions findRatingDescription(
			final EventRatings eventRatings) {
		final String hqlString = "select distinct rd from RatingDescriptions rd where rd.eventRatings=:eventRatings";
		final Query query = getQuery(hqlString);
		query.setParameter("eventRatings", eventRatings);
		List<RatingDescriptions> ratingDescriptions = query.getResultList();
		return ListExtensions.getFirst(ratingDescriptions);
	}
}