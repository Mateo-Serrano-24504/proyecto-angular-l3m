package backend.Infraestructura.output.persistencia.repository.puntaje;

import backend.Infraestructura.output.persistencia.projection.PromedioPuntaje;
import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PuntajeJpaRepository extends JpaRepository<PuntajeEntity,Long>, JpaSpecificationExecutor<PuntajeEntity> {
    @Query("""
        SELECT
            m.nombre as label,
            AVG(p.valor) as promedio
        FROM PuntajeEntity p
        JOIN p.materia m
        WHERE p.activo = true
        GROUP BY m.nombre
    """)
    List<PromedioPuntaje> obtenerPromedios();
}
