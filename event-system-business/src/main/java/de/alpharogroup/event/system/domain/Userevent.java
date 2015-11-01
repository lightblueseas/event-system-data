package de.alpharogroup.event.system.domain;

import de.alpharogroup.db.domain.BaseBusinessObject;
import de.alpharogroup.event.system.entities.EventTemplate;
import de.alpharogroup.event.system.enums.UsereventsRelationType;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.entities.Users;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Userevent extends BaseBusinessObject<Integer>
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The event attribute that references to the Entity class {@link EventTemplate}.
	 */
	private EventTemplateBusinessObject event;
	/** An enum for the type of the relation with the event. */
	private UsereventsRelationType relationtype;
	/** The user attribute that references to the Entity class {@link Users}. */
	private User user;
}
