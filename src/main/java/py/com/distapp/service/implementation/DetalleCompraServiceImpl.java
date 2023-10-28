package py.com.distapp.service.implementation;

import java.util.List;

import py.com.distapp.domain.DetalleCompra;
import py.com.distapp.repos.DetalleCompraRepository;
import py.com.distapp.service.DetalleCompraService;
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
