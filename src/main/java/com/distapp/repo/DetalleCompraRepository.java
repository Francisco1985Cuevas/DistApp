package com.distapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distapp.model.DetalleCompra;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {

}
