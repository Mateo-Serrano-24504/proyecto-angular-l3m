package backend.Aplicacion.mapper.estudiante.actualizar;

import backend.Aplicacion.dto.estudiante.actualizar.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.actualizar.ActualizarEstudianteDTOResponse;
import backend.Dominio.modelo.EstudianteModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ActualizarEstudianteMapper {
    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateModel(
            ActualizarEstudianteDTORequest dto,
            @MappingTarget EstudianteModel model
    );

    ActualizarEstudianteDTOResponse toDto(EstudianteModel model);
}
