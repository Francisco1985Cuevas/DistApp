package com.distapp.services.impl;

import java.util.Collection;
import java.util.List;

import com.distapp.model.DetalleCompra;
import com.distapp.repo.DetalleCompraRepository;
import com.distapp.services.DetalleCompraService;
import org.springframework.stereotype.Service;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {

	private DetalleCompraRepository repo;
	
	@Override
	public void create(DetalleCompra entity) {
		repo.save(entity);
		
	}

	@Override
	public void update(DetalleCompra entity) {
		repo.save(entity);
		
	}

	@Override
	public void delete(DetalleCompra entity) {
		repo.delete(entity);
		
	}

	@Override
	public List<DetalleCompra> findAll() {
		return repo.findAll();
	}

}
