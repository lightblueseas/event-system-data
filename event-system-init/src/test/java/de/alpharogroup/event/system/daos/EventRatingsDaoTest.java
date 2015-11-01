package de.alpharogroup.event.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.event.system.daos.EventRatingsDao;
import de.alpharogroup.event.system.entities.EventRatings;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class EventRatingsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private EventRatingsDao eventRatingsDao;

	@Test
	public void testFindAll() {
		List<EventRatings> list = eventRatingsDao.findAll();
	}

}
