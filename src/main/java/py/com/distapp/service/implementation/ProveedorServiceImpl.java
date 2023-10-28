package py.com.distapp.service.implementation;


import java.util.List;

import py.com.distapp.domain.Proveedor;
import py.com.distapp.repos.ProveedorRepository;
import py.com.distapp.service.ProveedorService;

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
