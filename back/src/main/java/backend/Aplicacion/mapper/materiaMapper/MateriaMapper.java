package backend.Aplicacion.mapper.materiaMapper;

import backend.Aplicacion.dto.materia.ListarMateriaDTOResponse;
import backend.Dominio.modelo.MateriaModel;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;

public class MateriaMapper {

    public static MateriaEntity toEntity(MateriaModel model) {
        MateriaEntity entity = new MateriaEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        return entity;
    }

    public static  MateriaModel toModel(MateriaEntity entity){
        MateriaModel model = new MateriaModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        return  model;
    }

    public static ListarMateriaDTOResponse toDto(MateriaModel model) {
    return new ListarMateriaDTOResponse(
            model.getId(),
            model.getNombre()
    );
}
}
