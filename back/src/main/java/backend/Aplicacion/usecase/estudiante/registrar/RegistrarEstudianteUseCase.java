package backend.Aplicacion.usecase.estudiante.registrar;

import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarEstudianteUseCase implements backend.Dominio.puertos.in.Student.RegistrarEstudiante {

    private final EstudianteRepositoryPort repository;

    @Override
    public Long ejecutar(RegistrarEstudianteDTORequest req) {
        EstudianteModel student = new EstudianteModel();
        student.setNombre(req.nombre());
        student.setApellido(req.apellido());
        student.setEmail(req.email());
        student.setDni(req.dni());

        EstudianteModel saved = repository.guardar(student);
        return saved.getId();
    }
}
