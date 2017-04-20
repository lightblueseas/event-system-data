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
 * The Entity class {@link Topics} is keeping the information for all the topics that events can
 * have. The table 'topics' has a tree structure so every topic has a parent. The root topic has no
 * parent.
 */
@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
public class Topics extends BaseEntity<Integer> implements Cloneable
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The name from the topic. */
	@Column(name = "name", length = 1024)
	private String name;
	/** A flag that indicates if this topic is a node. */
	@Column(name = "node")
	private Boolean node;
	/** The parent Topics object that references to the parent topic. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_TOPICS_PARENT_ID"))
	private Topics parent;

}
