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
 * The Entity class {@link Topics} is keeping the information for all the
 * topics that events can have. The table 'topics' has a tree structure so every
 * topic has a parent. The root topic has no parent.
 */
@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
public class Topics extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The name from the topic. */
	@Column(name = "name",length = 1024)
	private String name;
	/** A flag that indicates if this topic is a node. */
	@Column(name = "node")
	private Boolean node;
	/** The parent Topics object that references to the parent topic. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_TOPICS_PARENT_ID"))
	private Topics parent;

}
