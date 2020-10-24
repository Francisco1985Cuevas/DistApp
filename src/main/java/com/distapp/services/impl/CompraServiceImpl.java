package com.distapp.services.impl;

import java.util.List;

import com.distapp.model.Compra;
import com.distapp.repo.CompraRepository;
import com.distapp.services.CompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService{

	@Autowired
	private CompraRepository repo;
	
	@Override
	public void create(Compra entity) {
		repo.save(entity);
		
	}

	@Override
	public void update(Compra entity) {
		repo.save(entity);
		
	}

	@Override
	public void delete(Compra entity) {
		repo.delete(entity);
		
	}

	@Override
	public List<Compra> findAll() {
		return repo.findAll();
	}

}
