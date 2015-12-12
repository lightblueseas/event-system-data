package de.alpharogroup.event.system.rest;

import de.alpharogroup.event.system.domain.Category;
import de.alpharogroup.event.system.rest.api.CategoriesResource;
import de.alpharogroup.event.system.service.api.CategoryService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

public class CategoriesRestResource
extends
AbstractRestfulResource<Integer, Category, CategoryService>
implements
CategoriesResource
{

}
