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
import com.gaston.bigdata.mongodb.entity.Project;
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

		repo.deleteAll();
		System.out.println("Save 100000 Customers:");
		System.out.println("-------------------------------");
		long start = System.currentTimeMillis();
		// save a couple of customers
		for (int i = 0; i < 10000; i++) {
			String id = UUID.randomUUID().toString();
			if (i==0){
				id= "0";
			}
			Customer one = new Customer("Gaston-" + id, "De Leon-" + id);
			Project p1 = new Project("Project1-"+ id, 10);
			Project p2 = new Project("Project2-"+ id, 10);
			one.getProjects().add(p1);
			one.getProjects().add(p2);
			
			Customer two = new Customer("Nicolas-" + id, "Alonso-" + id);
			Project p3 = new Project("Project3-"+ id, 20);
			Project p4 = new Project("Project4-"+ id, 20);
			two.getProjects().add(p3);
			two.getProjects().add(p4);
			repo.save(p1);
			repo.save(p2);
			repo.save(one);
			repo.save(p3);
			repo.save(p4);
			repo.save(two);
		}

		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) + "ms");
		System.out.println();
		
		
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
		list = repo.findByFirstName("Gaston-0");
		for (Customer customer : list) {
			System.out.println(customer);
		}
		end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) + "ms");
		System.out.println();
		Assert.isTrue(true);
	}
}