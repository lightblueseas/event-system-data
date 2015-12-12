package de.alpharogroup.event.system.entities;

import javax.persistence.CascadeType;
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
 * An event can have multiply topics. The Entity class {@link EventTopics} is keeping the
 * information for the connection between the Entity class {@link EventTemplates} and the Entity class
 * {@link Topics}.
 */
@Entity
@Table(name = "event_topics")
@Getter
@Setter
@NoArgsConstructor
public class EventTopics extends BaseEntity<Integer> implements Cloneable
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The event attribute that references to the Entity class {@link EventTemplates}.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_EVENT_TOPICS_EVENT_ID"))
	private EventTemplates event;
	/**
	 * The topic attribute that references to the Entity class {@link Topics}.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_EVENT_TOPICS_TOPIC_ID"))
	private Topics topic;

}
