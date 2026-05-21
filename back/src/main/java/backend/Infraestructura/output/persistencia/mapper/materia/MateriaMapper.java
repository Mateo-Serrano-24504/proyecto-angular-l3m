package backend.Infraestructura.output.persistencia.mapper.materia;

import backend.Dominio.modelo.MateriaModel;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MateriaMapper {

    MateriaEntity toEntity(MateriaModel model);
    MateriaModel toModel(MateriaEntity entity);
}
