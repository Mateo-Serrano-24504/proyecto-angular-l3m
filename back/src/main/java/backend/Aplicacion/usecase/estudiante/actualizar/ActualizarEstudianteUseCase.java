package backend.Aplicacion.usecase.estudiante.actualizar;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.ListarEstudianteDTOResponse;
import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.in.Student.ActualizarEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizarEstudianteUseCase implements ActualizarEstudiante {
    private final EstudianteRepositoryPort repository;

    @Override
    public ListarEstudianteDTOResponse ejecutar(Long id, ActualizarEstudianteDTORequest req) {
        EstudianteModel estudiante = repository.buscarPorId(id);

        estudiante.setNombre(req.nombre());
        estudiante.setApellido(req.apellido());
        estudiante.setEmail(req.email());
        estudiante.setDni(req.dni());

        EstudianteModel actualizado = repository.guardar(estudiante);

        return StudentMapper.toDto(actualizado);
    }

}
