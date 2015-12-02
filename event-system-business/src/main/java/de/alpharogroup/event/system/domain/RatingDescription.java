package de.alpharogroup.event.system.domain;

import de.alpharogroup.domain.BaseDomainObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RatingDescription extends BaseDomainObject<Integer>
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The eventRatings attribute that references to the domain class {@link EventRating}.
	 */
	private EventRating eventRatings;
	/** A description what the user liked less from the event. */
	private String lessLikeRating;
	/** A description what the user liked most from the event. */
	private String mostLikeRating;
	/** A description if the user recommend the consultant from the event. */
	private String recommendConsultant;
	/** A description if the user recommend the event. */
	private String recommendEvent;
}
