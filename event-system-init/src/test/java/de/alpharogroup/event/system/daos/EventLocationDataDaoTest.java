package de.alpharogroup.event.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.event.system.daos.EventLocationDatasDao;
import de.alpharogroup.event.system.entities.EventLocationDatas;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class EventLocationDataDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private EventLocationDatasDao eventLocationDataDao;

	@Test
	public void testFindAll() {
		List<EventLocationDatas> list = eventLocationDataDao.findAll();
	}

}
