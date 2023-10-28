package py.com.distapp.service.implementation;

import java.util.List;

import py.com.distapp.domain.Compra;
import py.com.distapp.repos.CompraRepository;
import py.com.distapp.service.CompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {

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
