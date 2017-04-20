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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.user.entities.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link OfferedEventLocations} is keeping the information for the offered event
 * locations from a provider.
 */
@Entity
@Table(name = "offered_event_locations")
@Getter
@Setter
@NoArgsConstructor
public class OfferedEventLocations extends BaseEntity<Integer> implements Cloneable
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The eventLocationData attribute that references to the Entity class
	 * {@link EventLocationDatas}
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_location_data_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_OFFERED_EVENT_LOCATIONS_EVENT_LOCATION_DATA_ID"))
	private EventLocationDatas eventLocationData;
	/** A description from the location and how to get there. */
	@Column(name = "location_description", length = 21845)
	private String locationDescription;
	/** A description from the equipment from the event location. */
	@Column(name = "location_equipment_description", length = 21845)
	private String locationEquipmentDescription;
	/** A description from which provider is the location offered. */
	@Column(name = "offered_from_description", length = 21845)
	private String offeredFromDescription;
	/** A description of the support from this location. */
	@Column(name = "support_description", length = 21845)
	private String supportDescription;

	@ManyToOne
	@JoinColumn(name = "provider_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_OFFERED_EVENT_LOCATIONS_PROVIDER_ID"))
	private Users provider;

	/**
	 * The Addresses attribute that references to the Entity class {@link Addresses}.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_address_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_OFFERED_EVENT_LOCATIONS_USER_ADDRESS_ID"))
	private Addresses userAddress;
	/**
	 * The contactPerson attribute that references to the Entity class {@link Users} and is the
	 * contact person for this offered event location.
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_OFFERED_EVENT_LOCATIONS_CONTACT_PERSON_ID"))
	private Users contactPerson;

}
