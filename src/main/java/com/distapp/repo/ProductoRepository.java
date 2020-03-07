package com.distapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distapp.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
