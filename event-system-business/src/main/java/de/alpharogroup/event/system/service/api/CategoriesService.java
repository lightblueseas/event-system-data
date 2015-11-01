package de.alpharogroup.event.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.event.system.entities.Categories;

public interface CategoriesService extends
		BusinessService<Categories, java.lang.Integer> {

	/**
	 * Exists category.
	 * 
	 * @param name
	 *            the name
	 * @return true, if successful
	 */
	boolean existsCategory(final String name);

	/**
	 * Find category.
	 * 
	 * @param name
	 *            the name
	 * @return the categories object
	 */
	Categories findCategory(final String name);

	/**
	 * Find all categories from the given name.
	 * 
	 * @param name
	 *            the name
	 * @return the categories list
	 */
	List<Categories> find(String name);
}