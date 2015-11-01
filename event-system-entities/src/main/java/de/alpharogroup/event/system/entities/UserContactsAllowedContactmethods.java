package de.alpharogroup.event.system.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link UserContactsAllowedContactmethods} is holding the information for the
 * allowed contactmethods that the user can see from his contact person.
 */
@Entity
@Table(name = "user_contacts_allowed_contactmethods")
@Getter
@Setter
@NoArgsConstructor
public class UserContactsAllowedContactmethods extends BaseEntity<Integer>
		implements Cloneable {
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
	 * {@link Contactmethods} and is the allowed contact
	 * method from the user.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_contactmethod_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ALLOWED_CONTACTMETHODS_USER_CONTACTMETHOD_ID"))
	private Contactmethods userContactmethod;

}
