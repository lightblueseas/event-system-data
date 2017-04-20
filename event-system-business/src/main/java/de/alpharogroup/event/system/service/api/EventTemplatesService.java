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

import java.util.List;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.entities.EventTemplates;
import de.alpharogroup.user.entities.Users;

public interface EventTemplatesService extends BusinessService<EventTemplates, java.lang.Integer>
{

	/**
	 * Delete event and all references.
	 *
	 * @param event
	 *            the event
	 * @return the event template
	 */
	public EventTemplates deleteEventAndAllReferences(final EventTemplates event);

	/**
	 * Find seminar.
	 *
	 * @param provider
	 *            the provider
	 * @param id
	 *            the id
	 * @return the seminars
	 */
	EventTemplates findEvent(final Users provider, final Integer id);

	/**
	 * Find seminars.
	 *
	 * @param eventname
	 *            the eventname
	 * @param category
	 *            the category
	 * @param condition
	 *            the condition
	 * @return the list
	 */
	List<EventTemplates> findEvents(final String eventname, final Categories category,
		final boolean condition);

	/**
	 * Find seminars.
	 *
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<EventTemplates> findEvents(final Users provider);
}