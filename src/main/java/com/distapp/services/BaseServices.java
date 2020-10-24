package com.distapp.services;

import java.util.List;

public interface BaseServices<T> {
	//Esta seria mi Clase Principal o General de la cual heredan todas las demas.
	
	public abstract void create(T t);
	public abstract void update(T t);
	public abstract void delete(T t);
	public abstract List<T> findAll();
	//public abstract T findById(Long id);

}
