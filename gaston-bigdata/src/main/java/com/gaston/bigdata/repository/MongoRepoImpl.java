package com.gaston.bigdata.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.gaston.bigdata.mongodb.entity.Customer;
import com.gaston.bigdata.repository.interfaces.MongoRepo;

@Repository
public class MongoRepoImpl implements MongoRepo {

	@Autowired
	private MongoOperations operations;

	@Override
	public void deleteAll() {
		operations.dropCollection(Customer.class);

	}

	@Override
	public void save(Customer customer) {
		operations.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		return operations.findAll(Customer.class);
	}
	
	@Override
	public List<Customer> findByFirstName(String name){
		Query query = new BasicQuery("{firstName:'Gaston'}");
		return operations.find(query, Customer.class);
	}

}
