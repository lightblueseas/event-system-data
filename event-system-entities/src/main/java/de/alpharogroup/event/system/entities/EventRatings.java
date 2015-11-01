package de.alpharogroup.event.system.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import de.alpharogroup.rating.system.entities.Ratings;

/**
 * The Entity class {@link EventRatings} is keeping the information for the ratings from the events.
 */
@Entity
@Table(name = "event_ratings")
@TypeDefs({ @TypeDef(name = "ratingVisibilityConverter", typeClass = de.alpharogroup.db.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "de.alpharogroup.rating.system.enums.RatingVisibility") }) })
@Getter
@Setter
@NoArgsConstructor
public class EventRatings extends Ratings
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The rating for the contact. */
	@Column(name = "contact")
	private Integer contact;
	/**
	 * The event attribute that references to the Entity class {@link EventTemplate}.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_EVENT_RATINGS_EVENT_ID"))
	private EventTemplate event;
	/** The rating for the event location. */
	@Column(name = "eventlocation")
	private Integer eventlocation;
	/** The rating for the material. */
	@Column(name = "material")
	private Integer material;
	/** The rating for the presentation. */
	@Column(name = "presentation")
	private Integer presentation;
	/** The rating for the support. */
	@Column(name = "support")
	private Integer support;
	/** The rating for the topic. */
	@Column(name = "topic")
	private Integer topic;

}
