package com.gaston.bigdata.repository.interfaces;

import java.util.List;

import com.gaston.bigdata.mongodb.entity.Customer;

public interface MongoRepo {

	public void deleteAll();

	public void save(Customer customer);

	public List<Customer> findAll();
	
	public List<Customer> findByFirstName(String name);

}
