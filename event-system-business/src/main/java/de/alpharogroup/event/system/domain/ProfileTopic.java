package de.alpharogroup.event.system.domain;

import de.alpharogroup.db.domain.BaseBusinessObject;
import de.alpharogroup.user.management.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class ProfileTopic extends BaseBusinessObject<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The topic attribute that references to the domain class {@link Topic}.
	 */
	private Topic topic;
	/** The user attribute that references to the domain class {@link User}. */
	private User user;
}
