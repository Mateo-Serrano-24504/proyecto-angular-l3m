package backend.Infraestructura.output.persistencia.mapper.puntaje;

import backend.Dominio.modelo.PuntajeModel;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;
import backend.Infraestructura.output.persistencia.mapper.estudiante.EstudianteMapper;
import backend.Infraestructura.output.persistencia.mapper.materia.MateriaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EstudianteMapper.class, MateriaMapper.class})
public interface PuntajeMapper {

    @Mapping(target = "id", source = "model.id")
    @Mapping(target = "valor", source = "model.valor")
    @Mapping(target = "activo", source = "model.activo")
    @Mapping(target = "fechaPuntaje", source = "model.fechaPuntaje")
    @Mapping(target = "materia", source = "materia")
    @Mapping(target = "estudiante", source = "estudiante")
    PuntajeEntity toEntity(
            PuntajeModel model,
            MateriaEntity materia,
            EstudianteEntity estudiante
    );

    PuntajeModel toModel(PuntajeEntity entity);
}
