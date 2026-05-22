package backend.Aplicacion.mapper.materia;

import backend.Aplicacion.dto.materia.MateriaDTORequest;
import backend.Aplicacion.dto.materia.MateriaDTOResponse;
import backend.Dominio.modelo.MateriaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MateriaDtoMapper {
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateModel(
            MateriaDTORequest dto,
            @MappingTarget MateriaModel model
    );

    MateriaDTOResponse toDto(MateriaModel model);
}
