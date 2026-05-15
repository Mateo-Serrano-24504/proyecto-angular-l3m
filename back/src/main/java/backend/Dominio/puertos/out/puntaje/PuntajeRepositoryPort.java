package backend.Dominio.puertos.out.puntaje;

import backend.Dominio.modelo.PuntajeModel;

public interface PuntajeRepositoryPort {
    PuntajeModel guardar(PuntajeModel puntaje,Long materiaId, Long estudianteId);
}
