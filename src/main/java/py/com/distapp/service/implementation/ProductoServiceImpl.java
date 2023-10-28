package py.com.distapp.service.implementation;

import java.util.List;

import py.com.distapp.domain.Producto;
import py.com.distapp.repos.ProductoRepository;
import py.com.distapp.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repo;
	
	@Override
	public void create(Producto entity) {
		repo.save(entity);
		
	}

	@Override
	public void update(Producto entity) {
		repo.save(entity);
		
	}

	@Override
	public void delete(Producto entity) {
		repo.delete(entity);
		
	}

	@Override
	public List<Producto> findAll() {
		return repo.findAll();
	}

}
