package backend.Aplicacion.usecase.estudiante.obtenerEstudiantePorId;

import backend.Dominio.puertos.in.Student.ObtenerEstudiantePorId;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObtenerEstudiantePorIdPorIdUseCase implements ObtenerEstudiantePorId {
    private final EstudianteRepositoryPort repository;
}
