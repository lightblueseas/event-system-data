package de.alpharogroup.event.system.domain;

import de.alpharogroup.db.domain.BaseBusinessObject;
import de.alpharogroup.user.management.domain.ContactmethodBusinessObject;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Users;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserContactsAllowedContactmethod extends BaseBusinessObject<Integer>
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The userContact attribute that references to the Entity class {@link Users} and is the
	 * contact from the user.
	 */
	private User userContact;
	/**
	 * The userContactmethod attribute that references to the Entity class {@link Contactmethods}
	 * and is the allowed contact method from the user.
	 */
	private ContactmethodBusinessObject userContactmethod;
}
