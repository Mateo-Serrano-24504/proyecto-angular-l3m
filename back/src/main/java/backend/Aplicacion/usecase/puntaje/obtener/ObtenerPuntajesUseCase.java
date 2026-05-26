package backend.Aplicacion.usecase.puntaje.obtener;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;
import backend.Dominio.puertos.in.puntaje.ObtenerPuntajes;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObtenerPuntajesUseCase implements ObtenerPuntajes {

    private final PuntajeRepositoryPort repositoryPort;

    @Override
    public ObtenerPuntajesDTOResponse ejecutar() {
        return repositoryPort.obtener();
    }

    @Override
    public ObtenerPuntajesDTOResponse ejecutarParaAlumno(Long id) {
        return repositoryPort.obtener(id);
    }
}
