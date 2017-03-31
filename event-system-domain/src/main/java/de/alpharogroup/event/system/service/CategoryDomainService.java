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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.CategoriesDao;
import de.alpharogroup.event.system.domain.Category;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.mapper.CategoriesMapper;
import de.alpharogroup.event.system.service.api.CategoryService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("categoryDomainService")
public class CategoryDomainService
		extends AbstractDomainService<Integer, Category, Categories, CategoriesDao, CategoriesMapper>
		implements CategoryService {

	/**
	 * Sets the specific {@link CategoriesMapper}.
	 *
	 * @param mapper
	 *            the new {@link CategoriesMapper}.
	 */
	@Autowired
	public void setResourcesMapper(CategoriesMapper mapper) {
		setMapper(mapper);
	}

}
