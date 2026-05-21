package backend.Infraestructura.output.persistencia.adapater.studentAdapter;

import backend.Infraestructura.output.persistencia.mapper.pagination.PaginationMapper;
import backend.Aplicacion.shared.pagination.PageRequest;
import backend.Aplicacion.shared.pagination.PageResponse;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.mapper.estudiante.EstudianteMapper;
import backend.Infraestructura.output.persistencia.repository.estudiante.EstudianteJpaRepository;
import backend.Infraestructura.output.persistencia.specification.EstudianteActivoSpecification;
import backend.Infraestructura.output.persistencia.specification.factory.FilterRequestSpecificationBuilderFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
@Transactional
public class EstudianteRepositoryAdapter implements EstudianteRepositoryPort {

    private final EstudianteJpaRepository estudianteJpaRepository;
    private final EstudianteMapper mapper;
    private final FilterRequestSpecificationBuilderFactory<EstudianteEntity> factory;

    @Override
    public EstudianteModel guardar(EstudianteModel student) {
        EstudianteEntity entity = mapper.toEntity(student);
        EstudianteEntity saved = estudianteJpaRepository.save(entity);
        return mapper.toModel(saved);
    }

    @Override
    public PageResponse<EstudianteModel> listar(PageRequest request) {
        Pageable pageable = PaginationMapper.toPageable(request);
        Specification<EstudianteEntity> specification = EstudianteActivoSpecification
                .isActive()
                .and(this.factory.build(request.filterRequests()));
        return PaginationMapper.toPageResponse(
                this.estudianteJpaRepository
                        .findAll(
                                specification,
                                pageable
                        )
                        .map(mapper::toModel),
                request
        );
    }

    @Override
    public EstudianteModel buscarPorId(Long id) {
        return this.estudianteJpaRepository
                .findById(id)
                .map(mapper::toModel)
                .orElseThrow(() -> new RuntimeException("Estudiante de id " + id + " no existe"))
                .ifInactiveThrow();
    }

    @Override
    public void desactivar(Long id) {
         EstudianteEntity entity = this.estudianteJpaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante de id " + id + " no existe"));
         entity.setActive(false);
    }
}
