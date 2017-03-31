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

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.CategoriesDao;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.service.api.CategoriesService;
import de.alpharogroup.event.system.service.util.HqlStringCreator;

@Transactional
@Service("categoriesService")
public class CategoriesBusinessService extends AbstractBusinessService<Categories, java.lang.Integer, CategoriesDao>
		implements CategoriesService {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean existsCategory(String name) {
		return findCategory(name) != null;
	}

	@SuppressWarnings("unchecked")
	public List<Categories> find(String name) {
		String hqlString = HqlStringCreator.forCategories(name, Categories.class);
		final Query query = getQuery(hqlString);
		if (name != null) {
			query.setParameter("name", name);
		}
		final List<Categories> categories = query.getResultList();
		return categories;
	}

	@Override
	public Categories findCategory(String name) {
		return ListExtensions.getFirst(find(name));
	}

	@Autowired
	public void setCategoriesDao(CategoriesDao categoriesDao) {
		setDao(categoriesDao);
	}

}