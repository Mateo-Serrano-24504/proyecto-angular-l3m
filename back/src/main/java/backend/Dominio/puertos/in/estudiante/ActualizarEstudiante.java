package backend.Dominio.puertos.in.estudiante;

import backend.Aplicacion.dto.estudiante.actualizar.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.actualizar.ActualizarEstudianteDTOResponse;

public interface ActualizarEstudiante {
    ActualizarEstudianteDTOResponse ejecutar(Long id, ActualizarEstudianteDTORequest req);
}
