package backend.Dominio.puertos.in.puntaje;

import backend.Aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.Dominio.modelo.PuntajeModel;

public interface RegistrarPuntaje {
    PuntajeModel ejecutar(RegistrarPuntajeDTORequest req);
}
