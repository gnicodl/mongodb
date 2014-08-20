package com.gaston.bigdata.mongodb.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

	@Id
	private String id;

	@Indexed
	private String firstName;
	private String lastName;
	private List<Project> projects;

	public Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.projects = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		String s = String.format("Customer[id=%s, firstName='%s', lastName='%s']\n",
				id, firstName, lastName);
		for (Project p : this.projects) {
			s += String.format("Project[id='%s', name='%s', priority='%s']\n", p.getId(), p.getName(), p.getPriority());
		}
		return s;
	}
}