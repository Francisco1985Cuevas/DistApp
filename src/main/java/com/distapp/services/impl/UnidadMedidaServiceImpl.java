package com.distapp.services.impl;

import java.util.List;

import com.distapp.model.UnidadMedida;
import com.distapp.repo.UnidadMedidaRepository;
import com.distapp.services.UnidadMedidaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaServiceImpl implements UnidadMedidaService {

	@Autowired
	private UnidadMedidaRepository repo;
	
	@Override
	public void create(UnidadMedida entity) {
		repo.save(entity);
		
	}

	@Override
	public void update(UnidadMedida entity) {
		repo.save(entity);
		
	}

	@Override
	public void delete(UnidadMedida entity) {
		repo.delete(entity);
		
	}

	@Override
	public List<UnidadMedida> findAll() {
		return repo.findAll();
	}

}
