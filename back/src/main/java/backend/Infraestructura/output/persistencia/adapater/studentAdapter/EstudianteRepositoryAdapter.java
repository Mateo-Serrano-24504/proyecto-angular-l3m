package backend.Infraestructura.output.persistencia.adapater.studentAdapter;

import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Aplicacion.mapper.paginationMapper.PaginationMapper;
import backend.Aplicacion.pagination.PageRequest;
import backend.Aplicacion.pagination.PageResponse;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.repository.estudiante.EstudianteJpaRepository;
import backend.Infraestructura.output.persistencia.specification.EstudianteActivoSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
@Transactional
public class EstudianteRepositoryAdapter implements EstudianteRepositoryPort {

    private final EstudianteJpaRepository estudianteJpaRepository;

    @Override
    public EstudianteModel guardar(EstudianteModel student) {
        EstudianteEntity entity = StudentMapper.toEntity(student);
        EstudianteEntity saved = estudianteJpaRepository.save(entity);
        return StudentMapper.toModel(saved);
    }

    @Override
    public PageResponse<EstudianteModel> listar(PageRequest request) {
        Pageable pageable = PaginationMapper.toPageable(request);
        return PaginationMapper.toPageResponse(
                this.estudianteJpaRepository
                        .findAll(EstudianteActivoSpecification.isActive(), pageable)
                        .map(StudentMapper::toModel)
        );
    }

    @Override
    public EstudianteModel buscarPorId(Long id) {
        return this.estudianteJpaRepository
                .findById(id)
                .map(StudentMapper::toModel)
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
