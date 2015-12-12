package de.alpharogroup.event.system.domain;

import de.alpharogroup.rating.system.domain.Rating;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class EventRating extends Rating<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The rating for the contact. */
	private Integer contact;
	/**
	 * The event attribute that references to the domain class
	 * {@link EventTemplate}.
	 */
	private EventTemplate event;
	/** The rating for the event location. */
	private Integer eventlocation;
	/** The rating for the material. */
	private Integer material;
	/** The rating for the presentation. */
	private Integer presentation;
	/** The rating for the support. */
	private Integer support;
	/** The rating for the topic. */
	private Integer topic;
}
