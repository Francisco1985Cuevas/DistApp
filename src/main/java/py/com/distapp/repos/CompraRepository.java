package py.com.distapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.distapp.domain.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
