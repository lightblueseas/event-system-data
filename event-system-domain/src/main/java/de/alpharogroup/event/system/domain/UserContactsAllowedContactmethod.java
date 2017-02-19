package de.alpharogroup.event.system.domain;

import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.domain.User;
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
public class UserContactsAllowedContactmethod extends BaseDomainObject<Integer>
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The userContact attribute that references to the Entity class {@link User} and is the
	 * contact from the user.
	 */
	private User userContact;
	/**
	 * The userContactmethod attribute that references to the Entity class {@link Contactmethod}
	 * and is the allowed contact method from the user.
	 */
	private Contactmethod userContactmethod;
}
