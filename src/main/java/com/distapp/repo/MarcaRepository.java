package com.distapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.core.EntityInformation;

import com.distapp.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{
	Marca findById(long id);
}
