package backend.Aplicacion.usecase.estudiante.obtenerEstudiantePorId;

import backend.Aplicacion.dto.estudiante.ObtenerEstudiantePorIdDTOResponse;
import backend.Aplicacion.mapper.estudianteMapper.StudentProfileMapper;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.in.Student.ObtenerEstudiantePorIdPort;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObtenerEstudiantePorIdPorIdPortUseCase implements ObtenerEstudiantePorIdPort {
    private final PuntajeRepositoryPort puntajes;
    private final EstudianteRepositoryPort estudiantes;

    @Override
    public ObtenerEstudiantePorIdDTOResponse ejecutar(Long id) {
        EstudianteModel estudiante = this.estudiantes.buscarPorId(id);
        List<PuntajeModel> puntajes = this.puntajes.buscarPorIdDeAlumno(id);
        return StudentProfileMapper.toDto(estudiante, puntajes);
    }
}
