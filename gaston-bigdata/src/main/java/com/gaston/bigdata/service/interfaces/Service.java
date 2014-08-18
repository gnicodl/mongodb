package com.gaston.bigdata.service.interfaces;

import java.util.List;

/**
 * 
 * @author ( gaston.deleon@globant.com, gastonde.leon@autodesk.com )
 *
 * @param <T>
 */
public interface Service<T> {

	/**
	 * Saves an instance of T
	 * 
	 * @param t
	 */
	public Object save(T t);

	/**
	 * Retrieves an instance of T given its key.
	 * 
	 * @param key
	 *            | A key represented as an object (so we can generalize)
	 * @return
	 */
	T get(Object key);

	/**
	 * Deletes an instance of T given its key.
	 * 
	 * @param key
	 *            | A key represented as an object (so we can generalize)
	 * @return
	 */
	void delete(Object key);

	/**
	 * List all the instances of T
	 * 
	 * @return {@link List} of T
	 */
	List<T> list();

}
