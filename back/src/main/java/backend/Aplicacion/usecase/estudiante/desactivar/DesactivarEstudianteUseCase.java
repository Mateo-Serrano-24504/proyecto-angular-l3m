package backend.Aplicacion.usecase.estudiante.desactivar;

import backend.Dominio.puertos.in.estudiante.DesactivarEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DesactivarEstudianteUseCase implements DesactivarEstudiante {
    private final EstudianteRepositoryPort repository;

    @Override
    public void ejecutar(Long id) {
        this.repository.desactivar(id);
    }
}
