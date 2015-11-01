package de.alpharogroup.event.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.event.system.daos.TopicsDao;
import de.alpharogroup.event.system.entities.Topics;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class TopicsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private TopicsDao topicsDao;

	@Test
	public void testFindAll() {
		List<Topics> list = topicsDao.findAll();
	}

}
