package de.alpharogroup.event.system.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.user.management.entities.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link ProfileTopics} is keeping the information for the connection between the
 * Entity class {@link Users} and the Entity class {@link Topics}.
 */
@Entity
@Table(name = "profile_topics")
@Getter
@Setter
@NoArgsConstructor
public class ProfileTopics extends BaseEntity<Integer> implements Cloneable
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The topic attribute that references to the Entity class {@link Topics}.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PROFILE_TOPICS_TOPIC_ID"))
	private Topics topic;
	/** The user attribute that references to the Entity class {@link Users}. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PROFILE_TOPICS_USER_ID"))
	private Users user;

}
