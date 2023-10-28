package py.com.distapp.service.implementation;

import java.util.List;

import py.com.distapp.domain.Agencia;
import py.com.distapp.repos.AgenciaRepository;
import py.com.distapp.service.AgenciaService;

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
