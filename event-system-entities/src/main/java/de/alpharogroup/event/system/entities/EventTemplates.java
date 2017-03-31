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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.event.system.enums.Difficulty;
import de.alpharogroup.event.system.enums.EventType;
import de.alpharogroup.user.entities.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link EventTemplates} is keeping the information for the
 * events.
 */
@Entity
@Table(name = "events")
@TypeDefs({
		@TypeDef(name = "difficultyConverter", typeClass = de.alpharogroup.db.postgres.usertype.PGEnumUserType.class, parameters = {
				@Parameter(name = "enumClassName", value = "de.alpharogroup.event.system.enums.Difficulty") }),

		@TypeDef(name = "eventtypeConverter", typeClass = de.alpharogroup.db.postgres.usertype.PGEnumUserType.class, parameters = {
				@Parameter(name = "enumClassName", value = "de.alpharogroup.event.system.enums.EventType") }) })
@Getter
@Setter
@NoArgsConstructor
public class EventTemplates extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The category of the event. */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "categories_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_EVENTS_CATEGORIES_ID"))
	private Categories categories;
	/** The name of the consultant for the event. */
	@Column(name = "consultant", length = 64)
	private String consultant;
	/** A description for the content from the event. */
	@Column(name = "content", length = 21845)
	private String content;
	/** An enum for the difficulty from the event. */
	@Column(name = "difficulty")
	@Type(type = "difficultyConverter")
	private Difficulty difficulty;
	/** The duration in days from the event. */
	@Column(name = "duration")
	private Integer duration;
	/** An enum for the event type. */
	@Enumerated(EnumType.STRING)
	@Column(name = "eventtype")
	@Type(type = "eventtypeConverter")
	private EventType eventtype;
	/** The head text from the event. */
	@Column(name = "head", length = 21845)
	private String head;
	/** A description for the introduction from the event. */
	@Column(name = "introduction", length = 21845)
	private String introduction;
	/** The locale language from the event when it is registred. */
	@Column(name = "locale", length = 64)
	private String locale;
	/**
	 * A flag that signals if the provider have material for the event like
	 * books etc.
	 */
	@Column(name = "material")
	private Boolean material;
	/** The name from this event. */
	@Column(name = "name", length = 64)
	private String name;
	/** The price from the event. */
	@Column(name = "price")
	private java.math.BigDecimal price;
	/** The user id from the provider. */
	@Column(name = "provider")
	private Users provider;
	/** A description for the requirements from the event. */
	@Column(name = "requirements", length = 21845)
	private String requirements;
	/**
	 * The minimum that have to subscribe to this event so it can be executed.
	 */
	@Column(name = "subscribermax")
	private Integer subscribermax;
	/** The maximum that can subscribe to this event. */
	@Column(name = "subscribermin")
	private Integer subscribermin;
	/** A description for the targetgroup from the event. */
	@Column(name = "targetgroup", length = 21845)
	private String targetgroup;

}
