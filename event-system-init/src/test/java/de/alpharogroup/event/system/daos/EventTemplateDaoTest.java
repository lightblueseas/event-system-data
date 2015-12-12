package de.alpharogroup.event.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.event.system.daos.EventTemplatesDao;
import de.alpharogroup.event.system.entities.EventTemplates;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class EventTemplateDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private EventTemplatesDao eventTemplateDao;

	@Test
	public void testFindAll() {
		List<EventTemplates> list = eventTemplateDao.findAll();
	}

}
