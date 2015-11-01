package de.alpharogroup.event.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.event.system.daos.UserContactsAllowedContactmethodsDao;
import de.alpharogroup.event.system.entities.UserContactsAllowedContactmethods;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UserContactsAllowedContactmethodsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private UserContactsAllowedContactmethodsDao userContactsAllowedContactmethodsDao;

	@Test
	public void testFindAll() {
		List<UserContactsAllowedContactmethods> list = userContactsAllowedContactmethodsDao.findAll();
	}

}
