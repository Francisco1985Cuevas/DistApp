package py.com.distapp.service.implementation;


import java.util.List;

import py.com.distapp.domain.Kits;
import py.com.distapp.repos.KitsRepository;
import py.com.distapp.service.KitsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class kitsServiceImpl implements KitsService{

	@Autowired
	private KitsRepository repo;
	
	@Override
	public void create(Kits entity) {
		repo.save(entity);
		
	}

	@Override
	public void update(Kits entity) {
		repo.save(entity);
		
	}

	@Override
	public void delete(Kits entity) {
		repo.delete(entity);
		
	}

	@Override
	public List<Kits> findAll() {
		return repo.findAll();
	}

}
