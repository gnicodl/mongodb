package com.gaston.bigdata.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Project {

	@Id
	private String id;

	@Indexed
	private String name;
	private int priority;

	public Project() {
	}

	public Project(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return String.format("Project[id=%s, name='%s', priority='%s']", id,
				name, priority);
	}

}