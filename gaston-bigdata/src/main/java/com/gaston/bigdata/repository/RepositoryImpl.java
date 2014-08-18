package com.gaston.bigdata.repository;

import java.util.List;

import com.gaston.bigdata.repository.interfaces.Repository;

@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository<Object> {

	@Override
	public Object save(Object t) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Object get(Object key) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public void delete(Object key) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public List<Object> list() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

}
