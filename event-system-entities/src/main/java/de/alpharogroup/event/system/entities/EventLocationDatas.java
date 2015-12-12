package de.alpharogroup.event.system.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link EventLocationDatas} is keeping the
 * information for the data from the location. It is used if a provider wants to
 * offer an event location.
 */
@Entity
@Table(name = "event_location_data")
@Getter
@Setter
@NoArgsConstructor
public class EventLocationDatas extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The quantity of the available rooms or places. */
	@Column(name = "available_rooms")
	private Integer availableRooms;
	/** If the subscriber from the event location can hire a catering. */
	@Column(name = "catering_abilities")
	private Integer cateringAbilities;
	/** If the event location is near by a restaurant. */
	@Column(name = "near_by_restaurant")
	private Integer nearByRestaurant;
	/** If the event location is offered at evenings. */
	@Column(name = "offered_evening")
	private Boolean offeredEvening;
	/** If the event location is offered at weekdays. */
	@Column(name = "offered_weekdays")
	private Boolean offeredWeekdays;
	/** If the event location is offered at weekends. */
	@Column(name = "offered_weekend")
	private Boolean offeredWeekend;
	/** If the event location offer parking for cars. */
	@Column(name = "parking_abilities")
	private Integer parkingAbilities;
	/** The type of room from the offered room or place. */
	@Column(length = 256)
	private String roomtype;
	/** Available seats per room. */
	@Column(name = "seats_per_room")
	private Integer seatsPerRoom;

}
