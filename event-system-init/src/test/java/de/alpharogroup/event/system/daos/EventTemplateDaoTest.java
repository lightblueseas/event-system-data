package de.alpharogroup.event.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.event.system.daos.EventTemplateDao;
import de.alpharogroup.event.system.entities.EventTemplate;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class EventTemplateDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private EventTemplateDao eventTemplateDao;

	@Test
	public void testFindAll() {
		List<EventTemplate> list = eventTemplateDao.findAll();
	}

}
