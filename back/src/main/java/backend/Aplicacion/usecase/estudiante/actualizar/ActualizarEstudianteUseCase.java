package backend.Aplicacion.usecase.estudiante.actualizar;

import backend.Aplicacion.dto.estudiante.actualizar.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.actualizar.ActualizarEstudianteDTOResponse;
import backend.Aplicacion.mapper.estudiante.actualizar.ActualizarEstudianteMapper;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.in.Student.ActualizarEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizarEstudianteUseCase implements ActualizarEstudiante {
    private final EstudianteRepositoryPort repository;
    private final ActualizarEstudianteMapper mapper;

    @Override
    public ActualizarEstudianteDTOResponse ejecutar(Long id, ActualizarEstudianteDTORequest req) {
        EstudianteModel estudiante = repository.buscarPorId(id);

        mapper.updateModel(req, estudiante);

        EstudianteModel actualizado = repository.guardar(estudiante);

        return mapper.toDto(actualizado);
    }

}
