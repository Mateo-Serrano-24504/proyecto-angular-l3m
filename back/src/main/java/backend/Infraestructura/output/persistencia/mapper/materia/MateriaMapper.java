package backend.Infraestructura.output.persistencia.mapper.materia;

import backend.Dominio.modelo.MateriaModel;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MateriaMapper {

    @Mapping(target = "activo", source = "active")
    MateriaEntity toEntity(MateriaModel model);

    @Mapping(target = "active", source = "activo")
    MateriaModel toModel(MateriaEntity entity);
}
