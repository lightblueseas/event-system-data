package de.alpharogroup.event.system.service.locator;

import de.alpharogroup.event.system.service.api.CategoriesService;
import de.alpharogroup.event.system.service.api.EventLocationDatasService;
import de.alpharogroup.event.system.service.api.EventLocationsService;
import de.alpharogroup.event.system.service.api.EventMessagesService;
import de.alpharogroup.event.system.service.api.EventRatingsService;
import de.alpharogroup.event.system.service.api.EventTemplatesService;
import de.alpharogroup.event.system.service.api.EventTopicsService;
import de.alpharogroup.event.system.service.api.OfferedEventLocationsService;
import de.alpharogroup.event.system.service.api.ProfileFederalstatesService;
import de.alpharogroup.event.system.service.api.ProfileTopicsService;
import de.alpharogroup.event.system.service.api.RatingDescriptionsService;
import de.alpharogroup.event.system.service.api.TopicsService;
import de.alpharogroup.event.system.service.api.UserContactsAllowedContactmethodsService;
import de.alpharogroup.event.system.service.api.UsereventsService;

/**
 * The Interface ServiceLocator.
 */
public interface ServiceLocator
 extends
 de.alpharogroup.address.book.service.locator.ServiceLocator,
 de.alpharogroup.message.system.service.locator.ServiceLocator,
 de.alpharogroup.resource.system.service.locator.ServiceLocator,
 de.alpharogroup.user.management.service.locator.ServiceLocator,
 de.alpharogroup.scheduler.system.service.locator.ServiceLocator
{

	/**
	 * Gets the categories service.
	 *
	 * @return the categories service
	 */
	CategoriesService getCategoriesService();

	/**
	 * Sets the categories service.
	 *
	 * @param categoriesService the new categories service
	 */
	void setCategoriesService(CategoriesService categoriesService);

	/**
	 * Gets the event location data service.
	 *
	 * @return the event location data service
	 */
	EventLocationDatasService getEventLocationDatasService();

	/**
	 * Sets the event location data service.
	 *
	 * @param eventLocationDataService the new event location data service
	 */
	void setEventLocationDatasService(
			EventLocationDatasService eventLocationDataService);

	/**
	 * Gets the event locations service.
	 *
	 * @return the event locations service
	 */
	EventLocationsService getEventLocationsService();

	/**
	 * Sets the event locations service.
	 *
	 * @param eventLocationsService the new event locations service
	 */
	void setEventLocationsService(EventLocationsService eventLocationsService);

	/**
	 * Gets the event messages service.
	 *
	 * @return the event messages service
	 */
	EventMessagesService getEventMessagesService();

	/**
	 * Sets the event messages service.
	 *
	 * @param eventMessagesService the new event messages service
	 */
	void setEventMessagesService(EventMessagesService eventMessagesService);

	/**
	 * Gets the event ratings service.
	 *
	 * @return the event ratings service
	 */
	EventRatingsService getEventRatingsService();

	/**
	 * Sets the event ratings service.
	 *
	 * @param eventRatingsService the new event ratings service
	 */
	void setEventRatingsService(EventRatingsService eventRatingsService);

	/**
	 * Gets the event template service.
	 *
	 * @return the event template service
	 */
	EventTemplatesService getEventTemplatesService();

	/**
	 * Sets the event template service.
	 *
	 * @param eventTemplateService the new event template service
	 */
	void setEventTemplatesService(EventTemplatesService eventTemplateService);

	/**
	 * Gets the event topics service.
	 *
	 * @return the event topics service
	 */
	EventTopicsService getEventTopicsService();

	/**
	 * Sets the event topics service.
	 *
	 * @param eventTopicsService the new event topics service
	 */
	void setEventTopicsService(EventTopicsService eventTopicsService);

	/**
	 * Gets the offered event locations service.
	 *
	 * @return the offered event locations service
	 */
	OfferedEventLocationsService getOfferedEventLocationsService();

	/**
	 * Sets the offered event locations service.
	 *
	 * @param offeredEventLocationsService the new offered event locations service
	 */
	void setOfferedEventLocationsService(
			OfferedEventLocationsService offeredEventLocationsService);

	/**
	 * Gets the profile federalstates service.
	 *
	 * @return the profile federalstates service
	 */
	ProfileFederalstatesService getProfileFederalstatesService();

	/**
	 * Sets the profile federalstates service.
	 *
	 * @param profileFederalstatesService the new profile federalstates service
	 */
	void setProfileFederalstatesService(
			ProfileFederalstatesService profileFederalstatesService);

	/**
	 * Gets the profile topics service.
	 *
	 * @return the profile topics service
	 */
	ProfileTopicsService getProfileTopicsService();

	/**
	 * Sets the profile topics service.
	 *
	 * @param profileTopicsService the new profile topics service
	 */
	void setProfileTopicsService(ProfileTopicsService profileTopicsService);

	/**
	 * Gets the rating descriptions service.
	 *
	 * @return the rating descriptions service
	 */
	RatingDescriptionsService getRatingDescriptionsService();

	/**
	 * Sets the rating descriptions service.
	 *
	 * @param ratingDescriptionsService the new rating descriptions service
	 */
	void setRatingDescriptionsService(
			RatingDescriptionsService ratingDescriptionsService);

	/**
	 * Gets the topics service.
	 *
	 * @return the topics service
	 */
	TopicsService getTopicsService();

	/**
	 * Sets the topics service.
	 *
	 * @param topicsService the new topics service
	 */
	void setTopicsService(TopicsService topicsService);

	/**
	 * Gets the user contacts allowed contactmethods service.
	 *
	 * @return the user contacts allowed contactmethods service
	 */
	UserContactsAllowedContactmethodsService getUserContactsAllowedContactmethodsService();

	/**
	 * Sets the user contacts allowed contactmethods service.
	 *
	 * @param userContactsAllowedContactmethodsService the new user contacts allowed contactmethods service
	 */
	void setUserContactsAllowedContactmethodsService(
			UserContactsAllowedContactmethodsService userContactsAllowedContactmethodsService);

	/**
	 * Gets the userevents service.
	 *
	 * @return the userevents service
	 */
	UsereventsService getUsereventsService();

	/**
	 * Sets the userevents service.
	 *
	 * @param usereventsService the new userevents service
	 */
	void setUsereventsService(UsereventsService usereventsService);

}
