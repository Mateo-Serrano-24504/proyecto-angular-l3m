package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.obtenerPorId.ObtenerEstudiantePorIdDTOResponse;

public interface ObtenerEstudiantePorIdPort {
    ObtenerEstudiantePorIdDTOResponse ejecutar(Long id);
}
