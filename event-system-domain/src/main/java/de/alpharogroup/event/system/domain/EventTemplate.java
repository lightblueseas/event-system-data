package de.alpharogroup.event.system.domain;

import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.event.system.enums.Difficulty;
import de.alpharogroup.event.system.enums.EventType;
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
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventTemplate extends BaseDomainObject<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The category of the event. */
	private Category categories;
	/** The name of the consultant for the event. */
	private String consultant;
	/** A description for the content from the event. */
	private String content;
	/** An enum for the difficulty from the event. */
	private Difficulty difficulty;
	/** The duration in days from the event. */
	private Integer duration;
	/** An enum for the event type. */
	private EventType eventtype;
	/** The head text from the event. */
	private String head;
	/** A description for the introduction from the event. */
	private String introduction;
	/** The locale language from the event when it is registred. */
	private String locale;
	/**
	 * A flag that signals if the provider have material for the event like
	 * books etc.
	 */
	private Boolean material;
	/** The name from this event. */
	private String name;
	/** The price from the event. */
	private java.math.BigDecimal price;
	/** The user id from the provider. */
	private User provider;
	/** A description for the requirements from the event. */
	private String requirements;
	/** The minimum that have to subscribe to this event so it can be executed. */
	private Integer subscribermax;
	/** The maximum that can subscribe to this event. */
	private Integer subscribermin;
	/** A description for the targetgroup from the event. */
	private String targetgroup;
}
