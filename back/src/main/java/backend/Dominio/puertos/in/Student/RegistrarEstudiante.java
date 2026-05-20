package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.registrar.RegistrarEstudianteDTORequest;

public interface RegistrarEstudiante {
    Long ejecutar (RegistrarEstudianteDTORequest req);
}
