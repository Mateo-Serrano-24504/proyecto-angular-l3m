package backend.Aplicacion.mapper.materia;

import backend.Aplicacion.dto.materia.ListarMateriaDTOResponse;
import backend.Dominio.modelo.MateriaModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListarMateriasMapper {
    ListarMateriaDTOResponse toDto(MateriaModel model);
}
