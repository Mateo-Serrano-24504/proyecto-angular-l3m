package backend.Infraestructura.output.persistencia.repository.materia;

import backend.Dominio.modelo.MateriaModel;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MateriaJpaRepository extends JpaRepository<MateriaEntity, Long> {

}
