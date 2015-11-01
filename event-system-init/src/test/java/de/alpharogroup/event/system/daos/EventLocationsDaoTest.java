package de.alpharogroup.event.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.event.system.daos.EventLocationsDao;
import de.alpharogroup.event.system.entities.EventLocations;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class EventLocationsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private EventLocationsDao eventLocationsDao;

	@Test
	public void testFindAll() {
		List<EventLocations> list = eventLocationsDao.findAll();
	}

}
