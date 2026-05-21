package backend.Aplicacion.dto.puntaje;

import java.time.LocalDateTime;

public record ObtenerPuntajesPorEstudianteDniDTOResponse (
        Long id,
        String label,
        Double value,
        LocalDateTime fechaPuntaje
) {
}
