package py.com.distapp.service.implementation;

import java.util.List;

import py.com.distapp.domain.Configuracion;
import py.com.distapp.repos.ConfiguracionRepository;
import py.com.distapp.service.ConfiguracionService;
import org.springframework.stereotype.Service;

@Service
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
	public List<Configuracion> findAll() {
		return repo.findAll();
	}

}
