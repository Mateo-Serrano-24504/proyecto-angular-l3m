package backend.Infraestructura.output.persistencia.mapper.estudiante;

import backend.Dominio.modelo.EstudianteModel;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {
    EstudianteEntity toEntity(EstudianteModel model);
    EstudianteModel toModel(EstudianteEntity entity);
}
