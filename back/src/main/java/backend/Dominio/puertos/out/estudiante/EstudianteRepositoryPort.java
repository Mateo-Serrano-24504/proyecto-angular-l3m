package backend.Dominio.puertos.out.estudiante;

import backend.Dominio.modelo.EstudianteModel;

public interface EstudianteRepositoryPort {
    EstudianteModel guardar(EstudianteModel estudentiante);
}
