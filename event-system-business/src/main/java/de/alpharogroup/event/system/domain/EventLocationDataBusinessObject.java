package de.alpharogroup.event.system.domain;

import de.alpharogroup.db.domain.BaseBusinessObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class EventLocationDataBusinessObject extends BaseBusinessObject<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The quantity of the available rooms or places. */
	private Integer availableRooms;
	/** If the subscriber from the event location can hire a catering. */
	private Integer cateringAbilities;
	/** If the event location is near by a restaurant. */
	private Integer nearByRestaurant;
	/** If the event location is offered at evenings. */
	private Boolean offeredEvening;
	/** If the event location is offered at weekdays. */
	private Boolean offeredWeekdays;
	/** If the event location is offered at weekends. */
	private Boolean offeredWeekend;
	/** If the event location offer parking for cars. */
	private Integer parkingAbilities;
	/** The type of room from the offered room or place. */
	private String roomtype;
	/** Available seats per room. */
	private Integer seatsPerRoom;
}
