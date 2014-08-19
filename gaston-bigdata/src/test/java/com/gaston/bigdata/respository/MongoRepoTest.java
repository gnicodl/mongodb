package com.gaston.bigdata.respository;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.gaston.bigdata.mongodb.entity.Customer;
import com.gaston.bigdata.repository.interfaces.MongoRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:application-context.xml" })
public class MongoRepoTest {
	private static Logger logger = LoggerFactory.getLogger(MongoRepoTest.class);

	@Autowired
	private MongoRepo repo;

	@Test
	public void test() {
		logger.info("mongo repo");

		// repo.deleteAll();

		long start = System.currentTimeMillis();
		// save a couple of customers
		for (int i = 0; i < 100000; i++) {
			UUID id = UUID.randomUUID();
			repo.save(new Customer("Gaston-" + id, "De Leon-" + id));
			repo.save(new Customer("Nicolas-" + id, "Alonso-" + id));
		}

		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) + "ms");

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		start = System.currentTimeMillis();
		List<Customer> list = repo.findAll();
		/*for (Customer customer : repo.findAll()) {
			System.out.println(customer);
		}*/
		end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) + "ms");
		System.out.println();

		// fetch fist name customers
		System.out.println("Customers (Gaston) found with find():");
		System.out.println("-------------------------------");
		start = System.currentTimeMillis();
		list = repo.findByFirstName("Gaston");
		/*for (Customer customer : repo.findByFirstName("Gaston")) {
			System.out.println(customer);
		}*/
		end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) + "ms");
		System.out.println();
		Assert.isTrue(true);
	}
}