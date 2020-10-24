package com.distapp.services.impl;

import java.util.List;

import com.distapp.model.Marca;
import com.distapp.repo.MarcaRepository;
import com.distapp.services.MarcaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaRepository repo;/**/
	
	@Override
	public void create(Marca entity) {
		
		repo.save(entity);
		
	}

	@Override
	public void update(Marca entity) {
		repo.save(entity);
		
	}

	@Override
	public void delete(Marca entity) {
		repo.delete(entity);
		
	}

	@Override
	public List<Marca> findAll() {
		return repo.findAll();
	}
	
	@Override
	public Marca findById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
