package com.abuabdul.knodex.dao;

import java.util.List;

public interface KnodexDAO<T> {

	public T save(T entity);
	
	public T findOne(String id);

	public List<T> findAll();

	public List<T> findByKey(String key);

	public boolean exists(String key);
	
	public Long count();

	public void delete(T entity);
	
	public boolean deleteById(String id);

}
