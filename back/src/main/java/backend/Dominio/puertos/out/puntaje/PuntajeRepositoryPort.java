package backend.Dominio.puertos.out.puntaje;

import backend.Dominio.modelo.PuntajeModel;

import java.time.LocalDate;
import java.util.List;

public interface PuntajeRepositoryPort {
    PuntajeModel guardar(PuntajeModel puntaje, Long materiaId, Long estudianteId);
    List<PuntajeModel> buscarPorIdDeAlumno(Long id);
}
