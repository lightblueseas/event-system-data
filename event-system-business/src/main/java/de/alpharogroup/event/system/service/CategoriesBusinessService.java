package de.alpharogroup.event.system.service;

import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.event.system.daos.CategoriesDao;
import de.alpharogroup.event.system.entities.Categories;
import de.alpharogroup.event.system.service.api.CategoriesService;
import de.alpharogroup.event.system.service.util.HqlStringCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("categoriesService")
public class CategoriesBusinessService extends
		AbstractBusinessService<Categories, java.lang.Integer, CategoriesDao>
		implements CategoriesService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setCategoriesDao(CategoriesDao categoriesDao) {
		setDao(categoriesDao);
	}

	@Override
	public boolean existsCategory(String name) {
		return findCategory(name) != null;
	}

	@Override
	public Categories findCategory(String name) {
		return ListExtensions.getFirst(find(name));
	}
	
	@SuppressWarnings("unchecked")
	public List<Categories> find(String name) {
		String hqlString = HqlStringCreator.forCategories(name, Categories.class);
		final Query query = getQuery(hqlString);
		if(name != null){
			query.setParameter("name", name);
		}
		final List<Categories> categories = query.getResultList();
		return categories;
	}

}