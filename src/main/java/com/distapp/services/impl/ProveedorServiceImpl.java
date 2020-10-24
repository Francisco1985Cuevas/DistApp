package com.distapp.services.impl;


import java.util.List;

import com.distapp.model.Proveedor;
import com.distapp.repo.ProveedorRepository;
import com.distapp.services.ProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl implements ProveedorService {
	
	@Autowired
	private ProveedorRepository repo;

	@Override
	public void create(Proveedor entity) {
		repo.save(entity);
		
	}

	@Override
	public void update(Proveedor entity) {
		repo.save(entity);
		
	}

	@Override
	public void delete(Proveedor entity) {
		repo.delete(entity);
		
	}

	@Override
	public List<Proveedor> findAll() {
		return repo.findAll();
	}
	
}
