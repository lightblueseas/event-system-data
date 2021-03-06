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
package de.alpharogroup.event.system.factories;

import java.io.Serializable;
import java.util.Date;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.address.book.entities.Countries;
import de.alpharogroup.address.book.entities.Federalstates;
import de.alpharogroup.address.book.entities.Zipcodes;
import de.alpharogroup.address.book.factories.AddressBookFactory;
import de.alpharogroup.date.CreateDateExtensions;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.entities.EventLocationDatas;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.event.system.entities.EventMessages;
import de.alpharogroup.event.system.entities.EventRatings;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.entities.EventTopics;
import de.alpharogroup.event.system.entities.OfferedEventLocations;
import de.alpharogroup.event.system.entities.ProfileFederalstates;
import de.alpharogroup.event.system.entities.ProfileTopics;
import de.alpharogroup.event.system.entities.RatingDescriptions;
import de.alpharogroup.event.system.entities.Topics;
import de.alpharogroup.event.system.entities.UserContactsAllowedContactmethods;
import de.alpharogroup.event.system.entities.Userevents;
import de.alpharogroup.event.system.enums.Difficulty;
import de.alpharogroup.event.system.enums.EventType;
import de.alpharogroup.event.system.enums.UsereventsRelationType;
import de.alpharogroup.file.checksum.Algorithm;
import de.alpharogroup.file.checksum.ChecksumExtensions;
import de.alpharogroup.message.system.entities.MessageRecipients;
import de.alpharogroup.message.system.entities.Messages;
import de.alpharogroup.message.system.enums.MessageState;
import de.alpharogroup.message.system.enums.MessageType;
import de.alpharogroup.message.system.factories.MessageSystemFactory;
import de.alpharogroup.rating.system.enums.RatingVisibility;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.resource.system.factories.ResourceSystemFactory;
import de.alpharogroup.scheduler.system.entities.Appointments;
import de.alpharogroup.scheduler.system.enums.Rhythm;
import de.alpharogroup.scheduler.system.factories.SchedulerSystemFactory;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.entities.ResetPasswords;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.factories.UserManagementFactory;

/**
 * A factory for creating DomainObject objects.
 */
public class DomainObjectFactory implements Serializable
{

	/** The Constant instance. */
	private static final DomainObjectFactory instance = new DomainObjectFactory();

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the single instance of DomainObjectFactory.
	 * 
	 * @return single instance of DomainObjectFactory
	 */
	public static DomainObjectFactory getInstance()
	{
		return instance;
	}

	/**
	 * Instantiates a new domain object factory.
	 */
	private DomainObjectFactory()
	{
		super();
	}

	/**
	 * Gets the addresses.
	 *
	 * @param addressComment
	 *            the address comment
	 * @param federalstate
	 *            the federalstate
	 * @param geohash
	 *            the geohash
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 * @param street
	 *            the street
	 * @param streetnumber
	 *            the streetnumber
	 * @param zipcode
	 *            the zipcode
	 * @return the addresses
	 */
	public Addresses getAddresses(final String addressComment, final Federalstates federalstate,
		final String geohash, final java.math.BigDecimal latitude,
		final java.math.BigDecimal longitude, final String street, final String streetnumber,
		final Zipcodes zipcode)
	{
		String lat = (latitude != null) ? latitude.toString() : "";
		String lng = (longitude != null) ? longitude.toString() : "";
		return AddressBookFactory.getInstance().newAddresses(addressComment, federalstate, geohash,
			null, lat, lng, street, streetnumber, zipcode);
	}

	/**
	 * Gets the appointments.
	 * 
	 * @param endtime
	 *            the endtime
	 * @param nexttime
	 *            the nexttime
	 * @param rhythm
	 *            the rhythm
	 * @param starttime
	 *            the starttime
	 * @return the appointments
	 */
	public Appointments getAppointments(final Date endtime, final Date nexttime,
		final Rhythm rhythm, final Date starttime)
	{
		return SchedulerSystemFactory.getInstance().newAppointments(endtime, nexttime, rhythm,
			starttime);
	}

	/**
	 * Gets the categories.
	 * 
	 * @param name
	 *            the name
	 * @return the categories
	 */
	public Categories getCategories(final String name)
	{
		return EventSystemFactory.getInstance().newCategories(null, name);
	}

	/**
	 * Gets the contacts.
	 * 
	 * @param contactmethod
	 *            the contactmethod
	 * @param contactvalue
	 *            the contactvalue
	 * @return the contacts
	 */
	public Contactmethods getContactmethods(final ContactmethodType contactmethod,
		final String contactvalue)
	{
		return UserManagementFactory.getInstance().newContactmethods(contactmethod, contactvalue,
			null);
	}

	/**
	 * Gets the countries.
	 * 
	 * @param iso3166A2name
	 *            the iso3166 a2name
	 * @param iso3166A3name
	 *            the iso3166 a3name
	 * @param iso3166Number
	 *            the iso3166 number
	 * @param name
	 *            the name
	 * @return the countries
	 */
	public Countries getCountries(final String iso3166A2name, final String iso3166A3name,
		final String iso3166Number, final String name)
	{
		return AddressBookFactory.getInstance().newCountries(null, iso3166A2name, iso3166A3name,
			iso3166Number, name);
	}

	/**
	 * Gets the event location data.
	 * 
	 * @param availableRooms
	 *            the available rooms
	 * @param cateringAbilities
	 *            the catering abilities
	 * @param nearByRestaurant
	 *            the near by restaurant
	 * @param offeredEvening
	 *            the offered evening
	 * @param offeredWeekdays
	 *            the offered weekdays
	 * @param offeredWeekend
	 *            the offered weekend
	 * @param parkingAbilities
	 *            the parking abilities
	 * @param roomtype
	 *            the roomtype
	 * @param seatsPerRoom
	 *            the seats per room
	 * @return the event location data
	 */
	public EventLocationDatas getEventLocationData(final Integer availableRooms,
		final Integer cateringAbilities, final Integer nearByRestaurant,
		final Boolean offeredEvening, final Boolean offeredWeekdays, final Boolean offeredWeekend,
		final Integer parkingAbilities, final String roomtype, final Integer seatsPerRoom)
	{
		return EventSystemFactory.getInstance().newEventLocationData(availableRooms,
			cateringAbilities, null, nearByRestaurant, offeredEvening, offeredWeekdays,
			offeredWeekend, parkingAbilities, roomtype, seatsPerRoom);
	}

	/**
	 * Gets the event locations.
	 * 
	 * @param userAddress
	 *            the user address
	 * @param appointment
	 *            the appointment
	 * @param event
	 *            the event
	 * @param contactperson
	 *            the contactperson
	 * @return the event locations
	 */
	public EventLocations getEventLocations(final Addresses userAddress,
		final Appointments appointment, final EventTemplates event, final Users contactperson)
	{
		return EventSystemFactory.getInstance().newEventLocations(appointment, contactperson, event,
			null, userAddress);
	}

	/**
	 * Gets the event messages.
	 * 
	 * @param event
	 *            the event
	 * @param message
	 *            the message
	 * @return the event messages
	 */
	public EventMessages getEventMessages(final EventLocations event, final Messages message)
	{
		return EventSystemFactory.getInstance().newEventMessages(event, null, message);
	}

	/**
	 * Gets the event ratings.
	 *
	 * @param contact
	 *            the contact
	 * @param event
	 *            the event
	 * @param eventlocation
	 *            the eventlocation
	 * @param material
	 *            the material
	 * @param presentation
	 *            the presentation
	 * @param ratingDescription
	 *            the rating description
	 * @param support
	 *            the support
	 * @param titleRating
	 *            the title rating
	 * @param topic
	 *            the topic
	 * @param rater
	 *            the rater
	 * @param ratingDate
	 *            the rating date
	 * @param visibility
	 *            the visibility
	 * @return the event ratings
	 */
	public EventRatings getEventRatings(final Integer contact, final EventTemplates event,
		final Integer eventlocation, final Integer material, final Integer presentation,
		final String ratingDescription, final Integer support, final String titleRating,
		final Integer topic, final Users rater, final Date ratingDate,
		final RatingVisibility visibility)
	{
		return EventSystemFactory.getInstance().newEventRatings(contact, event, eventlocation, null,
			material, presentation, rater, ratingDate, ratingDescription, support, titleRating,
			topic, visibility);
	}

	/**
	 * Gets the events.
	 *
	 * @param categories
	 *            the categories
	 * @param consultant
	 *            the consultant
	 * @param content
	 *            the content
	 * @param difficulty
	 *            the difficulty
	 * @param duration
	 *            the duration
	 * @param eventtype
	 *            the eventtype
	 * @param head
	 *            the head
	 * @param introduction
	 *            the introduction
	 * @param locale
	 *            the locale
	 * @param material
	 *            the material
	 * @param name
	 *            the name
	 * @param price
	 *            the price
	 * @param provider
	 *            the provider
	 * @param requirements
	 *            the requirements
	 * @param subscribermax
	 *            the subscribermax
	 * @param subscribermin
	 *            the subscribermin
	 * @param targetgroup
	 *            the targetgroup
	 * @return the events
	 */
	public EventTemplates getEvents(final Categories categories, final String consultant,
		final String content, final Difficulty difficulty, final Integer duration,
		final EventType eventtype, final String head, final String introduction,
		final String locale, final Boolean material, final String name,
		final java.math.BigDecimal price, final Users provider, final String requirements,
		final Integer subscribermax, final Integer subscribermin, final String targetgroup)
	{
		return EventSystemFactory.getInstance().newEventTemplate(categories, consultant, content,
			difficulty, duration, eventtype, head, null, introduction, locale, material, name,
			price, provider, requirements, subscribermax, subscribermin, targetgroup);
	}

	/**
	 * Gets the event topics.
	 * 
	 * @param event
	 *            the event
	 * @param topic
	 *            the topic
	 * @return the event topics
	 */
	public EventTopics getEventTopics(final EventTemplates event, final Topics topic)
	{
		return EventSystemFactory.getInstance().newEventTopics(event, null, topic);
	}

	/**
	 * Gets the federalstates.
	 * 
	 * @param country
	 *            the country
	 * @param iso3166A2code
	 *            the iso3166 a2code
	 * @param name
	 *            the name
	 * @param subdivisionCategory
	 *            the subdivision category
	 * @param subdivisionName
	 *            the subdivision name
	 * @return the federalstates
	 */
	public Federalstates getFederalstates(final Countries country, final String iso3166A2code,
		final String name, final String subdivisionCategory, final String subdivisionName)
	{
		return AddressBookFactory.getInstance().newFederalstates(country, null, iso3166A2code, name,
			subdivisionCategory, subdivisionName);
	}

	/**
	 * Gets the images.
	 * 
	 * @param description
	 *            the description
	 * @param filename
	 *            the filename
	 * @param filesize
	 *            the filesize
	 * @param filetype
	 *            the filetype
	 * @param image
	 *            the image
	 * @return the images
	 */
	public Resources getImages(final String description, final String filename,
		final String filesize, final String filetype, final Byte[] image)
	{
		return ResourceSystemFactory.getInstance().newResources(null, description, filename,
			filesize, filetype, image, CreateDateExtensions.now(), false,
			ChecksumExtensions.getChecksumQuietly(image, Algorithm.SHA_256.getAlgorithm()));
	}

	/**
	 * Gets the message recipients.
	 * 
	 * @param message
	 *            the message
	 * @param recipient
	 *            the recipient
	 * @return the message recipients
	 */
	public MessageRecipients getMessageRecipients(final Messages message, final Users recipient)
	{
		return MessageSystemFactory.getInstance().newMessageRecipients(null, message, recipient);
	}

	/**
	 * Gets the messages.
	 *
	 * @param deletedFlag
	 *            the deleted flag
	 * @param failed2sentemail
	 *            the failed2sentemail
	 * @param folder
	 *            the folder
	 * @param messageContent
	 *            the message content
	 * @param messagetype
	 *            the messagetype
	 * @param readFlag
	 *            the read flag
	 * @param sender
	 *            the sender
	 * @param sentDate
	 *            the sent date
	 * @param spamFlag
	 *            the spam flag
	 * @param state
	 *            the state
	 * @param subject
	 *            the subject
	 * @return the messages
	 */
	public Messages getMessages(final Boolean deletedFlag, final Boolean failed2sentemail,
		final String folder, final String messageContent, final MessageType messagetype,
		final Boolean readFlag, final Users sender, final Date sentDate, final Boolean spamFlag,
		final MessageState state, final String subject)
	{
		return MessageSystemFactory.getInstance().newMessages(deletedFlag, failed2sentemail, folder,
			messageContent, messagetype, readFlag, sender, sentDate, spamFlag, state, subject);
	}

	/**
	 * Gets the offered event locations.
	 * 
	 * @param eventLocationData
	 *            the event location data
	 * @param locationDescription
	 *            the location description
	 * @param locationEquipmentDescription
	 *            the location equipment description
	 * @param offeredFromDescriptioin
	 *            the offered from descriptioin
	 * @param supportDescription
	 *            the support description
	 * @param userAddress
	 *            the user address
	 * @return the offered event locations
	 */
	public OfferedEventLocations getOfferedEventLocations(
		final EventLocationDatas eventLocationData, final String locationDescription,
		final String locationEquipmentDescription, final String offeredFromDescriptioin,
		final String supportDescription, final Addresses userAddress)
	{
		return EventSystemFactory.getInstance().newOfferedEventLocations(eventLocationData, null,
			locationDescription, locationEquipmentDescription, offeredFromDescriptioin,
			supportDescription, userAddress);
	}

	/**
	 * Gets the permissions.
	 * 
	 * @param description
	 *            the description
	 * @param permission
	 *            the permission
	 * @param shortcut
	 *            the shortcut
	 * @return the permissions
	 */
	public Permissions getPermissions(final String description, final String permission,
		final String shortcut)
	{
		return UserManagementFactory.getInstance().newPermissions(permission, description,
			shortcut);
	}

	/**
	 * Gets the profile federalstates.
	 * 
	 * @param federalstate
	 *            the federalstate
	 * @param user
	 *            the user
	 * @return the profile federalstates
	 */
	public ProfileFederalstates getProfileFederalstates(final Federalstates federalstate,
		final Users user)
	{
		return EventSystemFactory.getInstance().newProfileFederalstates(federalstate, null, user);
	}

	/**
	 * Gets the profile topics.
	 * 
	 * @param topic
	 *            the topic
	 * @param user
	 *            the user
	 * @return the profile topics
	 */
	public ProfileTopics getProfileTopics(final Topics topic, final Users user)
	{
		return EventSystemFactory.getInstance().newProfileTopics(null, topic, user);
	}

	/**
	 * Gets the rating descriptions.
	 * 
	 * @param lessLikeRating
	 *            the less like rating
	 * @param mostLikeRating
	 *            the most like rating
	 * @param recommendConsultant
	 *            the recommend consultant
	 * @param recommendEvent
	 *            the recommend event
	 * @param eventRatings
	 *            the event ratings
	 * @return the rating descriptions
	 */
	public RatingDescriptions getRatingDescriptions(final String lessLikeRating,
		final String mostLikeRating, final String recommendConsultant, final String recommendEvent,
		final EventRatings eventRatings)
	{
		return EventSystemFactory.getInstance().newRatingDescriptions(eventRatings, null,
			lessLikeRating, mostLikeRating, recommendConsultant, recommendEvent);
	}

	/**
	 * Gets the repliesandnotes.
	 * 
	 * @param message
	 *            the message
	 * @param replyornote
	 *            the replyornote
	 * @return the repliesandnotes
	 */
	public Messages getRepliesandnotes(final Messages message, final Messages replyornote)
	{
		replyornote.setParent(message);
		replyornote.setMessagetype(MessageType.REPLY);
		return replyornote;
	}

	public ResetPasswords getResetPasswords(final Date expiryDate, final String generatedPassword,
		final Date starttime, final Users user)
	{
		return UserManagementFactory.getInstance().newResetPasswords(expiryDate, generatedPassword,
			starttime, user);
	}

	/**
	 * Gets the roles.
	 * 
	 * @param description
	 *            the description
	 * @param rolename
	 *            the rolename
	 * @return the roles
	 */
	public Roles getRoles(final String description, final String rolename)
	{
		return UserManagementFactory.getInstance().newRoles(rolename, description);
	}

	/**
	 * Gets the topics.
	 * 
	 * @param name
	 *            the name
	 * @param node
	 *            the node
	 * @param parent
	 *            the parent
	 * @return the topics
	 */
	public Topics getTopics(final String name, final Boolean node, final Topics parent)
	{
		return EventSystemFactory.getInstance().newTopics(null, name, node, parent);
	}

	/**
	 * Gets the user contacts allowed contactmethods.
	 * 
	 * @param userContact
	 *            the user contact
	 * @param userContactmethod
	 *            the user contactmethod
	 * @return the user contacts allowed contactmethods
	 */
	public UserContactsAllowedContactmethods getUserContactsAllowedContactmethods(
		final Users userContact, final Contactmethods userContactmethod)
	{
		return EventSystemFactory.getInstance().newUserContactsAllowedContactmethods(null,
			userContact, userContactmethod);
	}

	/**
	 * Gets the user events.
	 * 
	 * @param event
	 *            the event
	 * @param relationtype
	 *            the relationtype
	 * @param user
	 *            the user
	 * @return the user events
	 */
	public Userevents getUserEvents(final EventTemplates event,
		final UsereventsRelationType relationtype, final Users user)
	{
		return EventSystemFactory.getInstance().newUserevents(event, null, relationtype, user);
	}

	/**
	 * Gets the user images.
	 * 
	 * @param image
	 *            the image
	 * @param user
	 *            the user
	 * @return the user images
	 */
	public Users getUserImages(final Resources image, final UserDatas user)
	{
		user.getResources().add(image);
		return null;
	}

	/**
	 * Gets the users.
	 *
	 * @param active
	 *            the active
	 * @param birthname
	 *            the birthname
	 * @param dateofbirth
	 *            the dateofbirth
	 * @param firstname
	 *            the firstname
	 * @param gender
	 *            the gender
	 * @param ipAddress
	 *            the ip address
	 * @param lastname
	 *            the lastname
	 * @param locale
	 *            the locale
	 * @param pw
	 *            the pw
	 * @param salt
	 *            the salt
	 * @param username
	 *            the username
	 * @return the users
	 */ // TODO check if this method is called and if not remove...
	// public Users getUsers( final Boolean active, final String birthname,
	// final Date dateofbirth, final String firstname,
	// final GenderType gender, final String ipAddress,
	// final String lastname, final String locale, final String pw,
	// final String salt, final String username ) {
	// return UserManagementFactory.getInstance().newUsers(null, active, pw,
	// salt, username, false,
	// UserManagementFactory.getInstance().newUserData(birthname, dateofbirth,
	// firstname, gender, ipAddress, lastname, locale), null);
	// }

	/**
	 * Gets the zipcodes.
	 * 
	 * @param city
	 *            the city
	 * @param zipcode
	 *            the zipcode
	 * @return the zipcodes
	 */
	public Zipcodes getZipcodes(final String city, final String zipcode)
	{
		return AddressBookFactory.getInstance().newZipcodes(null, city, zipcode);
	}

}
