package de.alpharogroup.event.system.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.event.system.domain.Category;
import de.alpharogroup.event.system.entities.Categories;


/**
 * The class {@link CategoriesMapper}.
 */
@Component
public class CategoriesMapper extends AbstractEntityDOMapper<Categories, Category> {

}
