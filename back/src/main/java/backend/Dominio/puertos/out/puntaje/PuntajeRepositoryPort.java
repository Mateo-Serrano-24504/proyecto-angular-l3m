package backend.Dominio.puertos.out.puntaje;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;
import backend.Dominio.modelo.PuntajeModel;

import java.util.List;

public interface PuntajeRepositoryPort {
    PuntajeModel guardar(PuntajeModel puntaje,Long materiaId, Long estudianteId);
    List<PuntajeModel> buscarPorIdDeAlumno(Long id);
    ObtenerPuntajesDTOResponse obtener();
    void desactivar(Long id);
}
