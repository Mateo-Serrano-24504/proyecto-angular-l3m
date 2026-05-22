package backend.Aplicacion.usecase.puntaje.registrar;

import backend.Aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.in.puntaje.RegistrarPuntaje;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class RegistrarPuntajeUseCase implements RegistrarPuntaje {

    private final PuntajeRepositoryPort puntajeRepositoryPort;

    @Override
    public PuntajeModel ejecutar(RegistrarPuntajeDTORequest req) {
        PuntajeModel puntaje = new PuntajeModel();
        puntaje.setValor(req.valor());
        puntaje.setFechaPuntaje(LocalDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires")));

        puntaje.activar();
        puntaje.validar();

        return puntajeRepositoryPort.guardar(puntaje, req.materiaId(), req.estudianteId());
    }
}
