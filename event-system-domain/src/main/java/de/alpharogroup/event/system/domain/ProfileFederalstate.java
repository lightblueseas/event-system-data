package de.alpharogroup.event.system.domain;

import de.alpharogroup.address.book.domain.Federalstate;
import de.alpharogroup.address.book.entities.Federalstates;
import de.alpharogroup.domain.BaseDomainObject;
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
public class ProfileFederalstate extends BaseDomainObject<Integer>
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The federalstate attribute that references to the Entity class {@link Federalstates}.
	 */
	private Federalstate federalstate;
	/** The user attribute that references to the Entity class {@link Users}. */
	private User user;
}
