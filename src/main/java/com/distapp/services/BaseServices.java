package com.distapp.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface BaseServices<T> {
	
	public abstract void create(T t);
	public abstract void update(T t);
	public abstract void delete(T t);
	public abstract Collection<T> findAll();

}
