/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.event.system.service.locator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.alpharogroup.address.book.service.api.AddressesService;
import de.alpharogroup.address.book.service.api.CountriesService;
import de.alpharogroup.address.book.service.api.FederalstatesService;
import de.alpharogroup.address.book.service.api.ZipcodesService;
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
import de.alpharogroup.message.system.service.api.MessageRecipientsService;
import de.alpharogroup.message.system.service.api.MessagesService;
import de.alpharogroup.resource.system.service.api.ResourcesService;
import de.alpharogroup.scheduler.system.service.api.AppointmentsService;
import de.alpharogroup.user.management.service.api.ContactmethodsService;
import de.alpharogroup.user.management.service.api.RecommendationsService;
import de.alpharogroup.user.management.service.api.RobinsonsService;
import de.alpharogroup.user.management.service.api.RuleViolationsService;
import de.alpharogroup.user.management.service.api.UserCreditsService;
import de.alpharogroup.user.management.service.api.UserDatasService;
import de.alpharogroup.user.management.service.api.UsersManagementService;
import de.alpharogroup.user.management.service.api.UsersService;
import de.alpharogroup.user.service.api.PermissionsService;
import de.alpharogroup.user.service.api.RelationPermissionsService;
import de.alpharogroup.user.service.api.ResetPasswordsService;
import de.alpharogroup.user.service.api.RolesService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class ServiceLocatorImpl.
 *
 * @author Asterios Raptis
 */
@Getter
@Setter
@NoArgsConstructor
@Service("serviceLocator")
public class ServiceLocatorImpl implements ServiceLocator {
	/** The AppointmentsService. */
	@Autowired
	private AppointmentsService appointmentsService;

	/** The RecommendationsService */
	@Autowired
	private RecommendationsService recommendationsService;

	/** The addresses service. */
	@Autowired
	private AddressesService addressesService;

	/** The RelationPermissions service. */
	@Autowired
	private RelationPermissionsService relationPermissionsService;

	/** The contactmethods service. */
	@Autowired
	private ContactmethodsService contactmethodsService;

	/** The countries service. */
	@Autowired
	private CountriesService countriesService;

	/** The federalstates service. */
	@Autowired
	private FederalstatesService federalstatesService;

	/** The ResourcesService. */
	@Autowired
	private ResourcesService resourcesService;

	/** The message recipients service. */
	@Autowired
	private MessageRecipientsService messageRecipientsService;

	/** The messages service. */
	@Autowired
	private MessagesService messagesService;

	/** The permission service. */
	@Autowired
	private PermissionsService permissionsService;

	/** The reset passwords service. */
	@Autowired
	private ResetPasswordsService resetPasswordsService;

	/** The roles service. */
	@Autowired
	private RolesService rolesService;

	/** The UserCredits service. */
	@Autowired
	private UserCreditsService userCreditsService;

	/** The users data service. */
	@Autowired
	private UserDatasService userDatasService;

	/** The user management service. */
	@Autowired
	private UsersManagementService userManagementService;

	/** The users service. */
	@Autowired
	private UsersService usersService;

	/** The zipcodes service. */
	@Autowired
	private ZipcodesService zipcodesService;

	/** The RuleViolations service. */
	@Autowired
	private RuleViolationsService ruleViolationsService;

	/** The Robinsons service. */
	@Autowired
	private RobinsonsService robinsonsService;

	/** The CategoriesService. */
	@Autowired
	private CategoriesService categoriesService;

	/** The EventLocationDataService. */
	@Autowired
	private EventLocationDatasService eventLocationDatasService;

	/** The EventLocationsService. */
	@Autowired
	private EventLocationsService eventLocationsService;

	/** The EventMessagesService. */
	@Autowired
	private EventMessagesService eventMessagesService;

	/** The EventRatingsService. */
	@Autowired
	private EventRatingsService eventRatingsService;

	/** The EventTemplateService. */
	@Autowired
	private EventTemplatesService eventTemplatesService;

	/** The EventTopicsService. */
	@Autowired
	private EventTopicsService eventTopicsService;

	/** The OfferedEventLocationsService. */
	@Autowired
	private OfferedEventLocationsService offeredEventLocationsService;

	/** The ProfileFederalstatesService. */
	@Autowired
	private ProfileFederalstatesService profileFederalstatesService;

	/** The ProfileTopicsService. */
	@Autowired
	private ProfileTopicsService profileTopicsService;

	/** The RatingDescriptionsService. */
	@Autowired
	private RatingDescriptionsService ratingDescriptionsService;

	/** The TopicsService. */
	@Autowired
	private TopicsService topicsService;

	/** The UserContactsAllowedContactmethodsService. */
	@Autowired
	private UserContactsAllowedContactmethodsService userContactsAllowedContactmethodsService;

	/** The UsereventsService. */
	@Autowired
	private UsereventsService usereventsService;

}
