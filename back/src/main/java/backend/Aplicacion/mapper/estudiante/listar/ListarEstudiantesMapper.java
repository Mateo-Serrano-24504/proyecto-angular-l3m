package backend.Aplicacion.mapper.estudiante.listar;

import backend.Aplicacion.dto.estudiante.listar.ListarEstudianteDTOResponse;
import backend.Dominio.modelo.EstudianteModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListarEstudiantesMapper {
    ListarEstudianteDTOResponse toDto(EstudianteModel model);
}
