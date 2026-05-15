package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;
import backend.Aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.Aplicacion.usecase.puntaje.Obtener.ObtenerPuntajes;
import backend.Aplicacion.usecase.puntaje.registrar.RegistrarPuntaje;
import backend.Dominio.modelo.PuntajeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/puntajes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PuntajeController {


    private final ObtenerPuntajes obtenerPuntajes;
    private final RegistrarPuntaje registrarPuntaje;


    @GetMapping("/chart")
    public ResponseEntity<ObtenerPuntajesDTOResponse> getChart() {
        ObtenerPuntajesDTOResponse chart = obtenerPuntajes.ejecutar();
        return ResponseEntity.ok(chart);
    }

    @PostMapping
    public ResponseEntity<PuntajeModel> registrar(@RequestBody RegistrarPuntajeDTORequest request) {
        PuntajeModel puntaje = registrarPuntaje.ejecutar(request);
        return ResponseEntity.ok(puntaje);
    }
}
