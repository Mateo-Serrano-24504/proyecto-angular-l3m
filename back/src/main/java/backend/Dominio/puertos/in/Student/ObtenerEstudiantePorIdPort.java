package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.ObtenerEstudiantePorIdDTOResponse;

public interface ObtenerEstudiantePorIdPort {
    ObtenerEstudiantePorIdDTOResponse ejecutar(Long id);
}
