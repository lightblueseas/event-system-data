package de.alpharogroup.event.system.application.model;

import de.alpharogroup.event.system.entities.Topics;
import de.alpharogroup.tree.TreeNode;

/**
 * The class {@link TopicTreeNode}.
 * 
 * @author Asterios Raptis
 */
public class TopicTreeNode extends TreeNode<Topics> {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new topic tree node.
	 * 
	 * @param value
	 *            the value
	 */
	public TopicTreeNode(final Topics value) {
		super(value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isNode() {
		return getValue().getNode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		if(getDisplayValue() != null) {
			return getDisplayValue();
		}
		return getValue().getName();
	}

}
