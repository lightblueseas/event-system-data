package de.alpharogroup.event.system.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link RatingDescriptions} is keeping the information for the rating
 * descriptions and is associatate with the Entity class {@link EventRatings}.
 */
@Entity
@Table(name = "rating_descriptions")
@Getter
@Setter
@NoArgsConstructor
public class RatingDescriptions extends BaseEntity<Integer> implements Cloneable
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The eventRatings attribute that references to the Entity class {@link EventRatings}.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_ratings_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_RATING_DESCRIPTIONS_EVENT_RATINGS_ID"))
	private EventRatings eventRatings;
	/** A description what the user liked less from the event. */
	@Column(name = "less_like_rating", length = 1024)
	private String lessLikeRating;
	/** A description what the user liked most from the event. */
	@Column(name = "most_like_rating", length = 1024)
	private String mostLikeRating;
	/** A description if the user recommend the consultant from the event. */
	@Column(name = "recommend_consultant", length = 1024)
	private String recommendConsultant;
	/** A description if the user recommend the event. */
	@Column(name = "recommend_event", length = 1024)
	private String recommendEvent;

}
