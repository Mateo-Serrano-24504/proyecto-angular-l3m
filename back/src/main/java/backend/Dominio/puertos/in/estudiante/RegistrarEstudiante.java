package backend.Dominio.puertos.in.estudiante;

import backend.Aplicacion.dto.estudiante.registrar.RegistrarEstudianteDTORequest;

public interface RegistrarEstudiante {
    Long ejecutar (RegistrarEstudianteDTORequest req);
}
