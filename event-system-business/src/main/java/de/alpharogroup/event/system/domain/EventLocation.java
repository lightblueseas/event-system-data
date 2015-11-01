package de.alpharogroup.event.system.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.db.domain.BaseBusinessObject;
import de.alpharogroup.scheduler.system.domain.Appointment;
import de.alpharogroup.scheduler.system.entities.Appointments;
import de.alpharogroup.user.management.domain.User;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class EventLocation extends BaseBusinessObject<Integer>
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The appointment attribute that references to the Entity class {@link Appointments}.
	 */
	private Appointment appointment;

	/**
	 * The contactperson attribute that references to the domain class {@link User}.
	 */
	private User contactperson;
	/**
	 * The event attribute that references to the domain class {@link EventTemplateBusinessObject}.
	 */
	private EventTemplateBusinessObject event;
	/**
	 * The eventLocation attribute that references to the domain class {@link Address}.
	 */
	private Address eventLocation;
}
