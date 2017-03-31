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
package de.alpharogroup.event.system.service.util;

import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.entities.EventLocations;
import de.alpharogroup.event.system.entities.EventMessages;
import de.alpharogroup.event.system.entities.Topics;
import de.alpharogroup.message.system.entities.Messages;

public class HqlStringCreator {

	public static void appendCondition(StringBuilder sb, String fieldName, String firstLetter, boolean... isNotNull) {
		boolean concatenated = false;
		for (int i = 0; i < isNotNull.length; i++) {
			if (i == 0) {
				concatenated = !isNotNull[i];
				continue;
			}
			concatenated = concatenated && !isNotNull[i];
		}
		sb.append(" ");
		String condition = firstLetter + "." + fieldName + "=:" + fieldName;
		if (concatenated) {
			sb.append("where " + condition);
		} else {
			sb.append("and " + condition);
		}
	}

	public static String forCategories(String name, Class<Categories> clazz) {
		StringBuilder sb = getSimpleSelect(clazz, true);
		String firstLetter = getFirstLetterLowerCase(clazz);
		boolean nameIsNotNull = name != null && !name.isEmpty();
		if (nameIsNotNull) {
			sb.append(" ");
			sb.append("where " + firstLetter + ".name=:name");
		}
		return sb.toString();
	}

	public static String forEventMessages(Messages message, EventLocations eventLocation, Class<EventMessages> clazz) {
		StringBuilder sb = getSimpleSelect(clazz, true);
		String firstLetter = getFirstLetterLowerCase(clazz);
		boolean messagesIsNotNull = message != null;
		if (messagesIsNotNull) {
			sb.append(" ");
			sb.append("where " + firstLetter + ".message=:message");
		}
		boolean eventLocationIsNotNull = eventLocation != null;
		if (eventLocationIsNotNull) {
			appendCondition(sb, "eventLocation", firstLetter, messagesIsNotNull);
		}
		return sb.toString();
	}

	public static String forTopics(String name, Boolean node, Topics parent) {
		StringBuilder sb = HqlStringCreator.getSimpleSelect(Topics.class, true);
		String firstLetter = getFirstLetterLowerCase(Topics.class);
		boolean nameIsNotNull = name != null && !name.isEmpty();
		if (nameIsNotNull) {
			appendCondition(sb, "name", firstLetter, true);
		}
		boolean nodeIsNotNull = node != null;
		if (nodeIsNotNull) {
			appendCondition(sb, "node", firstLetter, nameIsNotNull);
		}
		boolean parentIsNotNull = parent != null;
		if (parentIsNotNull) {
			appendCondition(sb, "parent", firstLetter, nameIsNotNull, nodeIsNotNull);
		}
		return sb.toString();
	}

	public static String getFirstLetterLowerCase(Class<?> clazz) {
		String simpleClassName = clazz.getSimpleName();
		String firstLetter = simpleClassName.substring(0, 1).toLowerCase();
		return firstLetter;
	}

	public static StringBuilder getSimpleSelect(Class<?> clazz, boolean distinct) {
		StringBuilder sb = new StringBuilder();
		String firstLetter = getFirstLetterLowerCase(clazz);
		if (distinct) {
			sb.append("select distinct " + firstLetter + " from " + clazz.getSimpleName() + " " + firstLetter);
		} else {
			sb.append("select " + firstLetter + " from " + clazz.getSimpleName() + " " + firstLetter);
		}
		return sb;
	}
}
