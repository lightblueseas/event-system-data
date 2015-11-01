package de.alpharogroup.event.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.event.system.daos.OfferedEventLocationsDao;
import de.alpharogroup.event.system.entities.OfferedEventLocations;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class OfferedEventLocationsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private OfferedEventLocationsDao offeredEventLocationsDao;

	@Test
	public void testFindAll() {
		List<OfferedEventLocations> list = offeredEventLocationsDao.findAll();
	}

}
