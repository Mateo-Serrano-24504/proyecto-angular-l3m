package backend.Dominio.puertos.in.puntaje;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesPorEstudianteDniDTOResponse;

import java.util.List;

public interface ListarPuntajesPorId {
    List<ObtenerPuntajesPorEstudianteDniDTOResponse> ejecutar(Long estudianteId);

}
