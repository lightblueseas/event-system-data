package de.alpharogroup.event.system.domain;

import de.alpharogroup.db.domain.BaseBusinessObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class Topic extends BaseBusinessObject<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The name from the topic. */
	private String name;
	/** A flag that indicates if this topic is a node. */
	private Boolean node;
	/** The parent Topics object that references to the parent topic. */
	private Topic parent;
}
