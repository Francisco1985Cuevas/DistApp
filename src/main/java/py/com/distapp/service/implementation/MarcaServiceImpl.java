package py.com.distapp.service.implementation;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import py.com.distapp.domain.Marca;
import py.com.distapp.model.dto.MarcaDTO;
import py.com.distapp.repos.MarcaRepository;
import py.com.distapp.service.MarcaService;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de marcas.
 */

@Service
@Validated
@Transactional
@Slf4j
public class MarcaServiceImpl implements MarcaService {
    private final MarcaRepository repository;

    public MarcaServiceImpl(MarcaRepository repository) {
        this.repository = repository;
    }

    private MarcaDTO mapToDTO(final Marca marca, final MarcaDTO marcaDTO) {
        marcaDTO.setId(marca.getId());
        marcaDTO.setNombre(marca.getNombre());
        marcaDTO.setEstado(marca.getEstado());
        marcaDTO.setCreatedBy(marca.getCreatedBy());
        marcaDTO.setCreatedAt(marca.getCreatedAt());
        marcaDTO.setUpdatedBy(marca.getUpdatedBy());
        marcaDTO.setUpdatedAt(marca.getUpdatedAt());
        marcaDTO.setDeleted(marca.isDeleted());
        marcaDTO.setDeletedBy(marca.getDeletedBy());
        marcaDTO.setDeletedAt(marca.getDeletedAt());
        return marcaDTO;
    }

    private Marca mapToEntity(final MarcaDTO marcaDTO, final Marca marca) {
        marca.setNombre(marcaDTO.getNombre().trim());
        marca.setEstado(marcaDTO.getEstado());
        marca.setCreatedBy(marcaDTO.getCreatedBy());
        marca.setCreatedAt(marcaDTO.getCreatedAt());
        marca.setUpdatedBy(marcaDTO.getUpdatedBy());
        marca.setUpdatedAt(marcaDTO.getUpdatedAt());
        marca.setDeleted(marcaDTO.isDeleted());
        marca.setDeletedBy(marcaDTO.getDeletedBy());
        marca.setDeletedAt(marcaDTO.getDeletedAt());
        return marca;
    }

    @Override
    public List<MarcaDTO> findAll() throws Exception {
        try {
            final List<Marca> marcas = repository.findAll(Sort.by("id"));
            return marcas.stream()
                    .map(marca -> mapToDTO(marca, new MarcaDTO()))
                    .toList();
        } catch (Exception e) {
            log.error("Error en el service de listado de Marcas: {}", e.getMessage());
            throw new Exception("Error en el service de listado de Marcas");
        }
    }

    @Override
    public MarcaDTO get(final Long id) throws Exception {
        try {
            return repository.findById(id)
                    .map(marca -> mapToDTO(marca, new MarcaDTO()))
                    .orElseThrow(Exception::new);
        } catch (Exception e) {
            log.error("Error en el service buscar marca por Id: {}", e.getMessage());
            throw new Exception("Error en el service buscar marca por Id");
        }
    }

    @Override
    public MarcaDTO getByNombre(final String nombre) throws Exception {
        try {
            return repository.findByNombre(nombre)
                    .map(marca -> mapToDTO(marca, new MarcaDTO()))
                    .orElseThrow(Exception::new);
        } catch (Exception e) {
            log.error("Error en el service buscar marca por Nombre: {}", e.getMessage());
            throw new Exception("Error en el service buscar marca por Nombre");
        }
    }

    @Override
    public Long create(final MarcaDTO marcaDTO) {
        final Marca marca = new Marca();
        mapToEntity(marcaDTO, marca);
        return repository.save(marca).getId();
    }

    @Override
    public void update(final Long id, MarcaDTO marcaDTO) throws Exception {
        final Marca marca = repository.findById(id).orElseThrow(Exception::new);
        log.info("Marca Encontrada:{}", marca);
        mapToEntity(marcaDTO, marca);
        repository.save(marca);


    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}

