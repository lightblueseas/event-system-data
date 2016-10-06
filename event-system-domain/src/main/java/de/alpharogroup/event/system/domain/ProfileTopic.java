package de.alpharogroup.event.system.domain;

import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.user.management.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileTopic extends BaseDomainObject<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The topic attribute that references to the domain class {@link Topic}.
	 */
	private Topic topic;
	/** The user attribute that references to the domain class {@link User}. */
	private User user;
}
