/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.event.system.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import de.alpharogroup.rating.system.entities.Ratings;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link EventRatings} is keeping the information for the
 * ratings from the events.
 */
@Entity
@Table(name = "event_ratings")
@TypeDefs({
		@TypeDef(name = "ratingVisibilityConverter", typeClass = de.alpharogroup.db.postgres.usertype.PGEnumUserType.class, parameters = {
				@Parameter(name = "enumClassName", value = "de.alpharogroup.rating.system.enums.RatingVisibility") }) })
@Getter
@Setter
@NoArgsConstructor
public class EventRatings extends Ratings {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The rating for the contact. */
	@Column(name = "contact")
	private Integer contact;
	/**
	 * The event attribute that references to the Entity class
	 * {@link EventTemplates}.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_EVENT_RATINGS_EVENT_ID"))
	private EventTemplates event;
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
