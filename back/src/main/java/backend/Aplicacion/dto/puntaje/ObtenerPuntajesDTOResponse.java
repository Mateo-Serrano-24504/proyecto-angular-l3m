package backend.Aplicacion.dto.puntaje;

import java.util.List;


public record ObtenerPuntajesDTOResponse(
        List<String> labels,
        List<Integer> data

) {
}
