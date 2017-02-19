package de.alpharogroup.event.system.domain;

import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.event.system.enums.UsereventsRelationType;
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
public class Userevent extends BaseDomainObject<Integer>
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The event attribute that references to the Entity class {@link EventTemplates}.
	 */
	private EventTemplate event;
	/** An enum for the type of the relation with the event. */
	private UsereventsRelationType relationtype;
	/** The user attribute that references to the Entity class {@link Users}. */
	private User user;
}
