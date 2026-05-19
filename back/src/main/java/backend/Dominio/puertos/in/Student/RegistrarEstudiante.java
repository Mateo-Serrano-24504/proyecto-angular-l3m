package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;

public interface RegistrarEstudiante {
    Long ejecutar (RegistrarEstudianteDTORequest req);
}
