package de.alpharogroup.event.system.domain;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.scheduler.system.domain.Appointment;
import de.alpharogroup.scheduler.system.entities.Appointments;
import de.alpharogroup.user.management.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventLocation extends BaseDomainObject<Integer>
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
	 * The event attribute that references to the domain class {@link EventTemplate}.
	 */
	private EventTemplate event;
	/**
	 * The eventLocation attribute that references to the domain class {@link Address}.
	 */
	private Address eventLocation;
}
