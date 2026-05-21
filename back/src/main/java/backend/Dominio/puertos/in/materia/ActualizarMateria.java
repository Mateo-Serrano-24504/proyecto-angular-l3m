package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.MateriaDTORequest;
import backend.Aplicacion.dto.materia.MateriaDTOResponse;

public interface ActualizarMateria {
    MateriaDTOResponse ejecutar(Long id, MateriaDTORequest dto);
}
