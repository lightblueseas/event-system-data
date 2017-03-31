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
package de.alpharogroup.event.system.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.application.model.TopicTreeNode;
import de.alpharogroup.event.system.daos.TopicsDao;
import de.alpharogroup.event.system.entities.Topics;
import de.alpharogroup.event.system.service.api.TopicsService;
import de.alpharogroup.event.system.service.util.HqlStringCreator;
import de.alpharogroup.tree.ifaces.ITreeNode;

@Transactional
@Service("topicsService")
public class TopicsBusinessService extends AbstractBusinessService<Topics, java.lang.Integer, TopicsDao>
		implements TopicsService {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Topics> find(String name, Boolean node, Topics parent) {
		String hqlString = HqlStringCreator.forTopics(name, node, parent);
		final Query query = getQuery(hqlString);
		if (name != null) {
			query.setParameter("name", name);
		}
		if (node != null) {
			query.setParameter("node", node);
		}
		if (parent != null) {
			query.setParameter("parent", parent);
		}
		final List<Topics> topics = query.getResultList();
		return topics;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Topics> getChildren(final Topics topic) {
		return find(null, null, topic);
	}

	/**
	 * {@inheritDoc}
	 */
	public Iterator<? extends Topics> getIteratorForChildren(final Topics topic) {
		final List<Topics> topics = getChildren(topic);
		if (null != topics && !topics.isEmpty()) {
			return topics.iterator();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Topics getRoot() {
		return get(Integer.valueOf(1));
	}

	/**
	 * {@inheritDoc}
	 */
	public ITreeNode<Topics> getRootTreeNode() {
		return getTreeNode(getRoot());
	}

	/**
	 * {@inheritDoc}
	 */
	public void getTopicTreeRecursive(final ITreeNode<Topics> taskElement) {
		final List<Topics> children = getChildren(taskElement.getValue());
		final List<ITreeNode<Topics>> childElements = new ArrayList<ITreeNode<Topics>>();
		if (children != null) {
			final Iterator<Topics> it = children.iterator();
			while (it.hasNext()) {
				final Topics childTopic = it.next();
				final ITreeNode<Topics> childElement = new TopicTreeNode(childTopic);
				childElements.add(childElement);
				getTopicTreeRecursive(childElement);
			}
			taskElement.setChildren(childElements);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ITreeNode<Topics> getTreeNode(final Topics topic) {
		final ITreeNode<Topics> root = new TopicTreeNode(topic);
		getTopicTreeRecursive(root);
		return root;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(final Topics topic) {
		final List<Topics> topics = getChildren(topic);
		return null != topics && !topics.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasParent(final Topics topic) {
		return null != topic.getParent();
	}

	@Autowired
	public void setTopicsDao(TopicsDao topicsDao) {
		setDao(topicsDao);
	}

}