package com.gaston.bigdata.respository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.gaston.bigdata.repository.interfaces.Repository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:application-context.xml" })
public class RepositoryTest {
	private static Logger logger = LoggerFactory
			.getLogger(RepositoryTest.class);

	@Autowired
	private Repository<Object> repo;

	@Test
	public void test() {
		logger.info("test");
		Assert.isTrue(true);
	}
}