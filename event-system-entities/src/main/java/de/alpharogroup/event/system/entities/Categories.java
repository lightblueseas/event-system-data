package de.alpharogroup.event.system.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link Categories} is keeping the information for
 * the categories from the events.
 */
@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Categories extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The name from the catecory. */
	@Column(length = 40)
	private String name;

}
