package backend.Infraestructura.output.persistencia.adapater.materia;

import backend.Aplicacion.shared.exception.NotFoundException;
import backend.Aplicacion.shared.pagination.PageRequest;
import backend.Aplicacion.shared.pagination.PageResponse;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.mapper.materia.MateriaMapper;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.mapper.pagination.PaginationMapper;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import backend.Infraestructura.output.persistencia.specification.EstudianteActivoSpecification;
import backend.Infraestructura.output.persistencia.specification.MateriaActivaSpecification;
import backend.Infraestructura.output.persistencia.specification.factory.FilterRequestSpecificationBuilderFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@AllArgsConstructor
@Transactional
public class MateriaRepositoryAdapter implements MateriaRepositoryPort {

    private final MateriaJpaRepository materiaJpaRepository;
    private final MateriaMapper mapper;

    @Override
    public MateriaModel guardar(MateriaModel materia) {
        MateriaEntity entity = mapper.toEntity(materia);
        MateriaEntity saved = materiaJpaRepository.save(entity);

        return mapper.toModel(saved);
    }

    @Override
    public void eliminar(Long id) {
        MateriaEntity entity = materiaJpaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Materia de id " + id + " no existe"));
        entity.setActivo(false);
    }

    @Override
    public PageResponse<MateriaModel> listar(PageRequest request) {
        Pageable pageable = PaginationMapper.toPageable(request);
        Specification<MateriaEntity> specification = MateriaActivaSpecification
                .isActive();
        return PaginationMapper.toPageResponse(
                this.materiaJpaRepository
                        .findAll(
                                specification,
                                pageable
                        )
                        .map(mapper::toModel),
                request
        );
    }

    @Override
    public List<MateriaModel> listarTodos() {
        Specification<MateriaEntity> specification = MateriaActivaSpecification
                .isActive();
        return this.materiaJpaRepository
                .findAll(specification)
                .stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public MateriaModel buscarPorId(Long id) {
        return this.materiaJpaRepository
                .findById(id)
                .map(mapper::toModel)
                .orElseThrow(() -> new NotFoundException("Materia de id " + id + " no existe"))
                .ifInactiveThrow();
    }


}
