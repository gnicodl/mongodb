package com.gaston.bigdata.service;

import java.util.List;

import com.gaston.bigdata.service.interfaces.Service;


@org.springframework.stereotype.Service
public class ServiceImpl implements Service<Object> {

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
