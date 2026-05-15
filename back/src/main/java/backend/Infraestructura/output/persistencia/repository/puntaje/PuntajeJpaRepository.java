package backend.Infraestructura.output.persistencia.repository.puntaje;

import backend.Dominio.modelo.PuntajeModel;
import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntajeJpaRepository extends JpaRepository<PuntajeEntity,Long> {
}
