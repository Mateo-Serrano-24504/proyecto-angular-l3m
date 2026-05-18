package backend.Aplicacion.mapper.estudianteMapper;

import backend.Aplicacion.dto.estudiante.ObtenerEstudiantePorIdDTOResponse;
import backend.Aplicacion.mapper.puntajeMapper.PuntajeMapper;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.PuntajeModel;

import java.util.List;

public class StudentProfileMapper {
    public static ObtenerEstudiantePorIdDTOResponse toDto(EstudianteModel model, List<PuntajeModel> puntajes) {
        return new ObtenerEstudiantePorIdDTOResponse(
                model.getId(),
                model.getNombre(),
                model.getApellido(),
                model.getEmail(),
                model.getDni(),
                puntajes.stream()
                        .map(PuntajeMapper::toDto)
                        .toList()
        );
    }
}
