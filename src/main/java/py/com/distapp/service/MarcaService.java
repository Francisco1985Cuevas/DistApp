package py.com.distapp.service;

import py.com.distapp.model.dto.MarcaDTO;

import java.util.List;

/*
public interface MarcaService extends BaseServices<Marca> {
	Marca findById(long id);
}
*/

public interface MarcaService {
    List<MarcaDTO> findAll() throws Exception;
    MarcaDTO get(Long id) throws Exception;
    MarcaDTO getByNombre(String nombre) throws Exception;
    Long create(MarcaDTO marcaDTO);
    void update(Long id, MarcaDTO marcaDTO) throws Exception;
    void delete(final Long id);
}