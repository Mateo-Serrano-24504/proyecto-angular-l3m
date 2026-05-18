package backend.Aplicacion.mapper.estudianteMapper;

import backend.Aplicacion.dto.estudiante.ListarEstudianteDTOResponse;
import backend.Dominio.modelo.EstudianteModel;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;

public class StudentMapper {

    public static EstudianteEntity toEntity(EstudianteModel model) {
        EstudianteEntity entity = new EstudianteEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setApellido(model.getApellido());
        entity.setEmail(model.getEmail());
        entity.setDni(model.getDni());
        return entity;
    }


    public static EstudianteModel toModel(EstudianteEntity entity) {
        EstudianteModel model = new EstudianteModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setApellido(entity.getApellido());
        model.setEmail(entity.getEmail());
        model.setDni(entity.getDni());
        return model;
    }

    public static ListarEstudianteDTOResponse toDto(EstudianteModel model) {
        return new ListarEstudianteDTOResponse(
                model.getId(),
                model.getNombre(),
                model.getApellido(),
                model.getEmail(),
                model.getDni()
        );
    }
}
