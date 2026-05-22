package backend.Infraestructura.output.persistencia.mapper.puntaje;

import backend.Dominio.modelo.PuntajeModel;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
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