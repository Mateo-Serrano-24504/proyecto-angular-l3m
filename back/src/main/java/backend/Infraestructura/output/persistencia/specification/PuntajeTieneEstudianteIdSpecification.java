package backend.Infraestructura.output.persistencia.specification;

import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;
import org.springframework.data.jpa.domain.Specification;

public class PuntajeTieneEstudianteIdSpecification {
    public static Specification<PuntajeEntity> hasEstudianteId(Long id) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("estudiante").get("id"),
                        id
                );
    }
}

//VER SI ESTA BIEN
//public class PuntajeTieneEstudianteIdSpecification {
//    public static Specification<PuntajeEntity> hasEstudianteId(Long estudianteId) {
//        return (root, query, cb) ->
//                cb.equal(
//                        root.get("estudiante").get("id"),
//                        estudianteId
//                );
//    }
//}
