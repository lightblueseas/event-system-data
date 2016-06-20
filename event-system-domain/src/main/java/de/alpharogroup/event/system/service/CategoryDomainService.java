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
extends
AbstractDomainService<Integer,
Category,
Categories,
CategoriesDao,
CategoriesMapper>
implements
CategoryService
{
	

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
