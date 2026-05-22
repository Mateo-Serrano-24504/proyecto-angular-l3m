package backend.Aplicacion.dto.estudiante.obtenerPorId;

import java.time.LocalDateTime;

public record ObtenerPuntajesPorEstudianteIdDTOResponse(
        Long id,
        String label,
        Double value,
        LocalDateTime fecha
) {}
