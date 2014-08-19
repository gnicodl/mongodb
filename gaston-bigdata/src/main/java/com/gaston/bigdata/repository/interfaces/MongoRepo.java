package com.gaston.bigdata.repository.interfaces;

import java.util.List;

import com.gaston.bigdata.mongodb.entity.Customer;
import com.gaston.bigdata.mongodb.entity.Project;

public interface MongoRepo {

	public void deleteAll();

	public void save(Customer customer);
	
	public void save(Project project);

	public List<Customer> findAll();
	
	public List<Customer> findByFirstName(String name);

}
