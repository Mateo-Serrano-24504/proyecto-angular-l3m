package backend.Dominio.puertos.in.puntaje;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;

public interface ObtenerPuntajes {
    ObtenerPuntajesDTOResponse ejecutar();
    ObtenerPuntajesDTOResponse ejecutarParaAlumno(Long id);
}
