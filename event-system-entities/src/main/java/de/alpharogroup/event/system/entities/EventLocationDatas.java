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
package de.alpharogroup.event.system.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link EventLocationDatas} is keeping the information for the data from the
 * location. It is used if a provider wants to offer an event location.
 */
@Entity
@Table(name = "event_location_data")
@Getter
@Setter
@NoArgsConstructor
public class EventLocationDatas extends BaseEntity<Integer> implements Cloneable
{
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
