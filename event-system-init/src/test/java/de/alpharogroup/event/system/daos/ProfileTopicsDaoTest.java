package de.alpharogroup.event.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.event.system.daos.ProfileTopicsDao;
import de.alpharogroup.event.system.entities.ProfileTopics;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class ProfileTopicsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private ProfileTopicsDao profileTopicsDao;

	@Test
	public void testFindAll() {
		List<ProfileTopics> list = profileTopicsDao.findAll();
	}

}
