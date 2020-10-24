package com.distapp.services.impl;


import java.util.List;

import com.distapp.model.Kits;
import com.distapp.repo.KitsRepository;
import com.distapp.repo.MarcaRepository;
import com.distapp.services.KitsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class kitsServiceImpl implements KitsService{

	@Autowired
	private KitsRepository repo;
	
	@Override
	public void create(Kits entity) {
		repo.save(entity);
		
	}

	@Override
	public void update(Kits entity) {
		repo.save(entity);
		
	}

	@Override
	public void delete(Kits entity) {
		repo.delete(entity);
		
	}

	@Override
	public List<Kits> findAll() {
		return repo.findAll();
	}

}
