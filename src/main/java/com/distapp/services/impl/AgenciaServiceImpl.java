package com.distapp.services.impl;

import java.util.List;

import com.distapp.model.Agencia;
import com.distapp.repo.AgenciaRepository;
import com.distapp.services.AgenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaServiceImpl implements AgenciaService {

	@Autowired
	private AgenciaRepository repo;
	
	@Override
	public void create(Agencia entity) {
		repo.save(entity);
	}

	@Override
	public void update(Agencia entity) {
		repo.save(entity);
	}

	@Override
	public void delete(Agencia entity) {
		repo.delete(entity);
	}

	@Override
	public List<Agencia> findAll() {
		return repo.findAll();
	}
	
	
}
