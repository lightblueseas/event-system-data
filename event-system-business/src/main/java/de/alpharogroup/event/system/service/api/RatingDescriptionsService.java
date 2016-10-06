package de.alpharogroup.event.system.service.api;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.event.system.entities.EventRatings;
import de.alpharogroup.event.system.entities.RatingDescriptions;

public interface RatingDescriptionsService extends
		BusinessService<RatingDescriptions, java.lang.Integer> {
	/**
	 * Find rating description.
	 * 
	 * @param eventRatings
	 *            the event ratings
	 * @return the rating descriptions
	 */
	RatingDescriptions findRatingDescription(EventRatings eventRatings);
}