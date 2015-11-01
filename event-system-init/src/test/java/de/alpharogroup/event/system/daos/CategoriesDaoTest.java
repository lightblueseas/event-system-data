package de.alpharogroup.event.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.event.system.daos.CategoriesDao;
import de.alpharogroup.event.system.entities.Categories;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class CategoriesDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private CategoriesDao categoriesDao;

	@Test
	public void testFindAll() {
		List<Categories> list = categoriesDao.findAll();
	}

}
