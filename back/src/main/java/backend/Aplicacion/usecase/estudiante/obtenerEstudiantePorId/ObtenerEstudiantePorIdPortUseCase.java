package backend.Aplicacion.usecase.estudiante.obtenerEstudiantePorId;

import backend.Aplicacion.dto.estudiante.obtenerPorId.ObtenerEstudiantePorIdDTOResponse;
import backend.Aplicacion.mapper.estudiante.obtenerPorId.ObtenerEstudiantePorIdMapper;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.in.estudiante.ObtenerEstudiantePorIdPort;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObtenerEstudiantePorIdPortUseCase implements ObtenerEstudiantePorIdPort {
    private final PuntajeRepositoryPort puntajes;
    private final EstudianteRepositoryPort estudiantes;
    private final ObtenerEstudiantePorIdMapper mapper;

    @Override
    public ObtenerEstudiantePorIdDTOResponse ejecutar(Long id) {
        EstudianteModel estudiante = this.estudiantes.buscarPorId(id);
        List<PuntajeModel> puntajes = this.puntajes.buscarPorIdDeAlumno(id);
        return mapper.toDto(estudiante, puntajes);
    }
}
