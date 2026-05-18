package backend.Infraestructura.output.persistencia.adapater.studentAdapter;

import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Aplicacion.mapper.paginationMapper.PaginationMapper;
import backend.Aplicacion.pagination.PageRequest;
import backend.Aplicacion.pagination.PageResponse;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.repository.estudiante.EstudianteJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
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
                        .findAll(pageable)
                        .map(StudentMapper::toModel)
        );
    }
}
