package backend.Aplicacion.dto.estudiante;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesPorEstudianteDniDTOResponse;

import java.util.List;

public record ObtenerEstudiantePorIdDTOResponse (
        Long id,
        String nombre,
        String apellido,
        String email,
        Integer dni,
        List<ObtenerPuntajesPorEstudianteDniDTOResponse> puntajes
) {}
