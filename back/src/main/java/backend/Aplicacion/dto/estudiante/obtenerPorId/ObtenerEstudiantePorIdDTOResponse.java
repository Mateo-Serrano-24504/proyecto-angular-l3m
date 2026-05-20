package backend.Aplicacion.dto.estudiante.obtenerPorId;

import java.util.List;

public record ObtenerEstudiantePorIdDTOResponse (
        Long id,
        String nombre,
        String apellido,
        String email,
        Integer dni,
        List<ObtenerPuntajesPorEstudianteIdDTOResponse> puntajes
) {}
