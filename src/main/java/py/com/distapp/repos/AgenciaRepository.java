package py.com.distapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import py.com.distapp.domain.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long>{

	Agencia findByDocumento(String doc);
}
