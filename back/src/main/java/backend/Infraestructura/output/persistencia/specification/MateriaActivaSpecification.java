package backend.Infraestructura.output.persistencia.specification;

import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import org.springframework.data.jpa.domain.Specification;

public class MateriaActivaSpecification {
    public static Specification<MateriaEntity> isActive() {
        return (root, query, cb) ->
                cb.equal(
                        root.get("activo"), true
                );
    }
}
