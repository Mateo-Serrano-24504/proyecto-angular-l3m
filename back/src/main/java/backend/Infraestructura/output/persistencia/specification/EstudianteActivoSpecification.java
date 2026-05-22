package backend.Infraestructura.output.persistencia.specification;

import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import org.springframework.data.jpa.domain.Specification;

public class EstudianteActivoSpecification {
    public static Specification<EstudianteEntity> isActive() {
        return (root, query, cb) ->
                cb.equal(
                        root.get("active"), true
                );
    }
}
