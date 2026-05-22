package backend.Infraestructura.output.persistencia.repository.materia;

import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MateriaJpaRepository extends JpaRepository<MateriaEntity, Long>,
        JpaSpecificationExecutor<MateriaEntity> {
}
