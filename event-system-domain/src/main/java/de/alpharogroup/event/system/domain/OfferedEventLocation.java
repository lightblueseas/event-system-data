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
package de.alpharogroup.event.system.domain;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.event.system.entities.EventLocationDatas;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.entities.Users;
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
public class OfferedEventLocation extends BaseDomainObject<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The eventLocationData attribute that references to the Entity class
	 * {@link EventLocationDatas}
	 */
	private EventLocationData eventLocationData;
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
	 * The Address attribute that references to the Entity class
	 * {@link Addresses}.
	 */
	private Address userAddress;
	/**
	 * The contactPerson attribute that references to the Entity class
	 * {@link Users} and is the contact person for this offered event location.
	 */
	private User contactPerson;
}
