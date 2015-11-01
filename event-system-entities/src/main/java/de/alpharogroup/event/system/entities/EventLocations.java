package de.alpharogroup.event.system.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.scheduler.system.entities.Appointments;
import de.alpharogroup.user.management.entities.Users;

/**
 * The Entity class {@link EventLocations} is keeping the
 * information for the event locations with the appointments.
 */
@Entity
@Table(name = "event_locations")
@Getter
@Setter
@NoArgsConstructor
public class EventLocations extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The appointment attribute that references to the Entity class
	 * {@link Appointments}.
	 */
	@ManyToOne
	@JoinColumn(name = "appointment_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_EVENTLOCATIONS_APPOINTMENT_ID"))
	private Appointments appointment;
	
	/**
	 * The contactperson attribute that references to the Entity class {@link Users }.
	 */
	@ManyToOne
	@JoinColumn(name = "contactperson_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_EVENTLOCATIONS_CONTACTPERSON_ID"))
	private Users contactperson;
	/**
	 * The event attribute that references to the Entity class {@link EventTemplate}.
	 */
	@ManyToOne
	@JoinColumn(name = "event_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_EVENTLOCATIONS_EVENT_ID"))
	private EventTemplate event;
	/**
	 * The eventLocation attribute that references to the Entity class
	 * {@link Addresses}.
	 */
	@ManyToOne
	@JoinColumn(name = "event_location_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_EVENT_LOCATION_ID"))
	private Addresses eventLocation;

}