package backend.Aplicacion.mapper.estudiante.obtenerPorId;

import backend.Aplicacion.dto.estudiante.obtenerPorId.ObtenerEstudiantePorIdDTOResponse;
import backend.Aplicacion.dto.estudiante.obtenerPorId.ObtenerPuntajesPorEstudianteIdDTOResponse;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.PuntajeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObtenerEstudiantePorIdMapper {
    @Mapping(target = "puntajes", source = "puntajes")
    ObtenerEstudiantePorIdDTOResponse toDto(
            EstudianteModel model,
            List<PuntajeModel> puntajes
    );

    @SuppressWarnings("unused")
    ObtenerPuntajesPorEstudianteIdDTOResponse toDto(
            PuntajeModel model
    );
}
