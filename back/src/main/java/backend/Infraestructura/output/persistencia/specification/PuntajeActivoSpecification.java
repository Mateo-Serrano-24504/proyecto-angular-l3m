package backend.Infraestructura.output.persistencia.specification;

import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;
import org.springframework.data.jpa.domain.Specification;

public class PuntajeActivoSpecification {
    public static Specification<PuntajeEntity> isActive() {
        return (root, query, cb) ->
                cb.equal(
                        root.get("activo"), true
                );
    }
}
