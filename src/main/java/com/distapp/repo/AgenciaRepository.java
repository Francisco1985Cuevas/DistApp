package com.distapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.distapp.model.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long>{

	Agencia findByDocumento(String doc);
}
