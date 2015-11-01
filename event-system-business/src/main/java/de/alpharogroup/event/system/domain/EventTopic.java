package de.alpharogroup.event.system.domain;

import de.alpharogroup.db.domain.BaseBusinessObject;
import de.alpharogroup.event.system.entities.EventTemplate;
import de.alpharogroup.event.system.entities.Topics;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class EventTopic extends BaseBusinessObject<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The event attribute that references to the Entity class {@link EventTemplate}.
	 */
	private EventTemplateBusinessObject event;
	
	/**
	 * The topic attribute that references to the Entity class {@link Topics}.
	 */
	private Topic topic;
}
