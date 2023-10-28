package py.com.distapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.distapp.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
