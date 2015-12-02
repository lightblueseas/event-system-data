package de.alpharogroup.event.system.domain;

import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.message.system.domain.Message;
import de.alpharogroup.message.system.entities.Messages;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class EventMessage extends BaseDomainObject<Integer>
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The eventLocation attribute that references to the Entity class {@link EventLocations}.
	 */
	private EventLocation eventLocation;
	/**
	 * The message attribute that references to the Entity class {@link Messages}.
	 */
	private Message message;
}
