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
package de.alpharogroup.event.system.service.api;

import java.util.Iterator;
import java.util.List;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.event.system.entities.Topics;
import de.alpharogroup.tree.ifaces.ITreeNode;

/**
 * The Interface TopicsService.
 */
public interface TopicsService extends BusinessService<Topics, java.lang.Integer>
{

	/**
	 * Finds a list from the given name, node and parent parameters.
	 *
	 * @param name
	 *            the name
	 * @param node
	 *            the node
	 * @param parent
	 *            the parent
	 * @return the list
	 */
	List<Topics> find(String name, Boolean node, Topics parent);

	/**
	 * Gets the children.
	 * 
	 * @param topic
	 *            the topic
	 * @return the children
	 */
	List<Topics> getChildren(final Topics topic);

	/**
	 * Gets the iterator for children.
	 * 
	 * @param topic
	 *            the topic
	 * @return the iterator for children
	 */
	Iterator<? extends Topics> getIteratorForChildren(final Topics topic);

	/**
	 * Gets the root.
	 * 
	 * @return the root
	 */
	Topics getRoot();

	/**
	 * Gets the root tree node.
	 * 
	 * @return the root tree node
	 */
	ITreeNode<Topics> getRootTreeNode();

	/**
	 * Gets the topic tree recursive.
	 *
	 * @param taskElement
	 *            the task element
	 */
	void getTopicTreeRecursive(final ITreeNode<Topics> taskElement);

	/**
	 * Gets the tree node.
	 * 
	 * @param topic
	 *            the topic
	 * @return the tree node
	 */
	ITreeNode<Topics> getTreeNode(final Topics topic);

	/**
	 * Checks for children.
	 * 
	 * @param topic
	 *            the topic
	 * @return true, if successful
	 */
	boolean hasChildren(final Topics topic);

	/**
	 * Checks for parent.
	 * 
	 * @param topic
	 *            the topic
	 * @return true, if successful
	 */
	boolean hasParent(final Topics topic);
}