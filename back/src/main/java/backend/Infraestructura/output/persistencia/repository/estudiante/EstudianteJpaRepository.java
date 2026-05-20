package backend.Infraestructura.output.persistencia.repository.estudiante;

import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstudianteJpaRepository extends JpaRepository<EstudianteEntity, Long>,
        JpaSpecificationExecutor<EstudianteEntity> {
}