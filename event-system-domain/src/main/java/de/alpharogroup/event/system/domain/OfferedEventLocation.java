package de.alpharogroup.event.system.domain;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.event.system.entities.EventLocationData;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.entities.Users;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OfferedEventLocation extends BaseDomainObject<Integer>
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The eventLocationData attribute that references to the Entity class {@link EventLocationData}
	 */
	private EventLocationDataBusinessObject eventLocationData;
	/** A description from the location and how to get there. */
	private String locationDescription;
	/** A description from the equipment from the event location. */
	private String locationEquipmentDescription;
	/** A description from which provider is the location offered. */
	private String offeredFromDescription;
	/** A description of the support from this location. */
	private String supportDescription;

	private User provider;

	/**
	 * The Address attribute that references to the Entity class {@link Addresses}.
	 */
	private Address userAddress;
	/**
	 * The contactPerson attribute that references to the Entity class {@link Users} and is the
	 * contact person for this offered event location.
	 */
	private User contactPerson;
}
