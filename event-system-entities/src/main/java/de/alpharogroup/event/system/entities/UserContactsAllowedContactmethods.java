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
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.entities.Contactmethods;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link UserContactsAllowedContactmethods} is holding the
 * information for the allowed contactmethods that the user can see from his
 * contact person.
 */
@Entity
@Table(name = "user_contacts_allowed_contactmethods")
@Getter
@Setter
@NoArgsConstructor
public class UserContactsAllowedContactmethods extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The userContact attribute that references to the Entity class
	 * {@link Users} and is the contact from the user.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_contact_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ALLOWED_CONTACTMETHODS_USER_CONTACT_ID"))
	private Users userContact;
	/**
	 * The userContactmethod attribute that references to the Entity class
	 * {@link Contactmethods} and is the allowed contact method from the user.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_contactmethod_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ALLOWED_CONTACTMETHODS_USER_CONTACTMETHOD_ID"))
	private Contactmethods userContactmethod;

}
