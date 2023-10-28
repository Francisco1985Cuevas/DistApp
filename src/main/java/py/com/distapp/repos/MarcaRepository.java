package py.com.distapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.distapp.domain.Marca;

import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca, Long>{
	Marca findById(long id);

	Optional<Marca> findByNombre(String nombre);

}
