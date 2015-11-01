package de.alpharogroup.event.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.event.system.entities.Userevents;
import de.alpharogroup.event.system.daos.UsereventsDao;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UsereventsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private UsereventsDao usereventsDao;

	@Test
	public void testFindAll() {
		List<Userevents> list = usereventsDao.findAll();
	}

}
