package py.com.distapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.distapp.domain.DetalleCompra;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {

}
