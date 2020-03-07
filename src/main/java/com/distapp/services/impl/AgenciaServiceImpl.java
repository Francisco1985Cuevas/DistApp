package com.distapp.services.impl;

import java.util.Collection;

import com.distapp.model.Agencia;
import com.distapp.repo.AgenciaRepository;
import com.distapp.services.AgenciaService;

public class AgenciaServiceImpl implements AgenciaService {

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
	public Collection<Agencia> findAll() {
		return repo.findAll();
	}

}
