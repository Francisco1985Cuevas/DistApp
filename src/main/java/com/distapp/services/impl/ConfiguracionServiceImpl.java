package com.distapp.services.impl;

import java.util.Collection;

import com.distapp.model.Configuracion;
import com.distapp.repo.ConfiguracionRepository;
import com.distapp.services.ConfiguracionService;

public class ConfiguracionServiceImpl implements ConfiguracionService {

	private ConfiguracionRepository repo;
	
	@Override
	public void create(Configuracion entity) {
		repo.save(entity);
	}

	@Override
	public void update(Configuracion entity) {
		repo.save(entity);
	}

	@Override
	public void delete(Configuracion entity) {
		repo.delete(entity);
	}

	@Override
	public Collection<Configuracion> findAll() {
		return repo.findAll();
	}

}
