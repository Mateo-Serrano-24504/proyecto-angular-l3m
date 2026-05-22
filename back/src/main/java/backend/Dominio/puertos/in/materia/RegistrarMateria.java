package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.MateriaDTORequest;

public interface RegistrarMateria {
    Long ejecutar (MateriaDTORequest req);
}
