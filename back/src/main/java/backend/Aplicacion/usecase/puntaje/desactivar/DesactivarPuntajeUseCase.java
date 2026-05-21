package backend.Aplicacion.usecase.puntaje.desactivar;

import backend.Dominio.puertos.in.puntaje.DesactivarPuntaje;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DesactivarPuntajeUseCase implements DesactivarPuntaje {

    private final PuntajeRepositoryPort repositoryPort;

    @Override
    public void desactivar(Long id) {
        this.repositoryPort.desactivar(id);
    }
}
