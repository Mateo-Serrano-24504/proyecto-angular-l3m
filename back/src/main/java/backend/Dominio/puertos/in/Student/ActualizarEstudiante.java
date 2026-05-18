package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.ListarEstudianteDTOResponse;

public interface ActualizarEstudiante {
    ListarEstudianteDTOResponse ejecutar(Long id, ActualizarEstudianteDTORequest req);
}
