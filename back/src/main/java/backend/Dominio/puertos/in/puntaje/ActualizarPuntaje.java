package backend.Dominio.puertos.in.puntaje;

import backend.Dominio.modelo.PuntajeModel;

public interface ActualizarPuntaje {
    PuntajeModel ejecutar(Long id, ActualizarPuntajeDTORequest request);

}

