package de.alpharogroup.event.system.domain;

import de.alpharogroup.domain.BaseDomainObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseDomainObject<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The name from the catecory. */
	private String name;
}
