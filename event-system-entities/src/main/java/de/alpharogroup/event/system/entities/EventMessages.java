package de.alpharogroup.event.system.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.message.system.entities.Messages;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link EventMessages} is keeping the information for the connection between the
 * Entity class {@link EventLocations} and the Entity class {@link Messages}.
 */
@Entity
@Table(name = "event_messages")
@Getter
@Setter
@NoArgsConstructor
public class EventMessages extends BaseEntity<Integer> implements Cloneable
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The eventLocation attribute that references to the Entity class {@link EventLocations}.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_location_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_EVENT_MESSAGES_EVENT_LOCATION_ID"))
	private EventLocations eventLocation;
	/**
	 * The message attribute that references to the Entity class {@link Messages}.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "message_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_EVENT_MESSAGES_MESSAGE_ID"))
	private Messages message;

}
