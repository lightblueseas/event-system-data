package de.alpharogroup.event.system.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.event.system.enums.UsereventsRelationType;
import de.alpharogroup.user.management.entities.Users;

/**
 * The Entity class {@link Userevents} is keeping the information for the connection between the
 * Entity class {@link Users} and the Entity class {@link EventTemplates}. It holds information from
 * providers that have 'provided' the event and from subscribers that have 'requested' the event.
 */
@Entity
@Table(name = "userevents")
@TypeDefs({ @TypeDef(name = "relationtypeConverter", typeClass = de.alpharogroup.db.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "de.alpharogroup.event.system.enums.UsereventsRelationType") }) })
@Getter
@Setter
@NoArgsConstructor
public class Userevents extends BaseEntity<Integer> implements Cloneable
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The event attribute that references to the Entity class {@link EventTemplates}.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_USEREVENTS_USER_ID"))
	private EventTemplates event;
	/** An enum for the type of the relation with the event. */
	@Enumerated(EnumType.STRING)
	@Column(name = "relationtype")
	@Type(type = "relationtypeConverter")
	private UsereventsRelationType relationtype;
	/** The user attribute that references to the Entity class {@link Users}. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_USEREVENTS_EVENT_ID"))
	private Users user;

}
