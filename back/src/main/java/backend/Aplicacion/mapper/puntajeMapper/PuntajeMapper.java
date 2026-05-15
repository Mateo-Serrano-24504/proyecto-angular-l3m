package backend.Aplicacion.mapper.puntajeMapper;

import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.modelo.PuntajeModel;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;

public class PuntajeMapper {

    public static PuntajeEntity toEntity(PuntajeModel model,
                                         MateriaEntity materia,
                                         EstudianteEntity estudiante) {
        PuntajeEntity entity = new PuntajeEntity();
        entity.setId(model.getId());
        entity.setValor(model.getValor());
        entity.setEstudiante(estudiante);
        entity.setMateria(materia);
        return entity;
    }

    public static PuntajeModel toModel(PuntajeEntity entity) {
        PuntajeModel model = new PuntajeModel();
        model.setId(entity.getId());
        model.setValor(entity.getValor());


        if (entity.getEstudiante() != null) {
            EstudianteModel estudianteModel = new EstudianteModel();
            estudianteModel.setId(entity.getEstudiante().getId());
            estudianteModel.setNombre(entity.getEstudiante().getNombre());
            estudianteModel.setApellido(entity.getEstudiante().getApellido());
            estudianteModel.setEmail(entity.getEstudiante().getEmail());
            estudianteModel.setDni(entity.getEstudiante().getDni());
            model.setEstudiante(estudianteModel);
        }

        if (entity.getMateria() != null) {
            MateriaModel materiaModel = new MateriaModel();
            materiaModel.setId(entity.getMateria().getId());
            materiaModel.setNombre(entity.getMateria().getNombre());
            model.setMateria(materiaModel);
        }

        return model;
    }
}
