package backend.Aplicacion.usecase.puntaje.obtener;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;
import backend.Dominio.puertos.in.puntaje.ObtenerPuntajes;
import backend.Infraestructura.output.persistencia.projection.PromedioPuntaje;
import backend.Infraestructura.output.persistencia.repository.puntaje.PuntajeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObtenerPuntajesUseCase implements ObtenerPuntajes {

    private final PuntajeJpaRepository puntajeJpaRepository;

    @Override
    public ObtenerPuntajesDTOResponse ejecutar(){
        var promedios = puntajeJpaRepository.obtenerPromedios();
        return new ObtenerPuntajesDTOResponse(
                promedios.stream()
                        .map(PromedioPuntaje::getLabel)
                        .toList(),

                promedios.stream()
                        .map(p -> p.getPromedio().intValue())
                        .toList()
        );
    }
}
