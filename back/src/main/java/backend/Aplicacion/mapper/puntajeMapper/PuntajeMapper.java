package backend.Aplicacion.mapper.puntajeMapper;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesPorEstudianteDniDTOResponse;
import backend.Dominio.modelo.PuntajeModel;

public class PuntajeMapper {

    public static ObtenerPuntajesPorEstudianteDniDTOResponse toDto(PuntajeModel model) {
        return new ObtenerPuntajesPorEstudianteDniDTOResponse(
                model.getId(),
                model.getMateria().getNombre(),
                model.getValor()
        );
    }
}
