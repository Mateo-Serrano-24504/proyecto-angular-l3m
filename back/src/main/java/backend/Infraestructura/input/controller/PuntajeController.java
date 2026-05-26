package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;
import backend.Aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.in.puntaje.DesactivarPuntaje;
import backend.Dominio.puertos.in.puntaje.ObtenerPuntajes;
import backend.Dominio.puertos.in.puntaje.RegistrarPuntaje;
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
    private final DesactivarPuntaje desactivarPuntaje;


    @GetMapping("/chart")
    public ResponseEntity<ObtenerPuntajesDTOResponse> getChart() {
        ObtenerPuntajesDTOResponse chart = obtenerPuntajes.ejecutar();
        return ResponseEntity.ok(chart);
    }

    @GetMapping("/chart/{id}")
    public ResponseEntity<ObtenerPuntajesDTOResponse> obtenerChartDeAlumno(@PathVariable Long id) {
        ObtenerPuntajesDTOResponse chart = obtenerPuntajes.ejecutarParaAlumno(id);
        return ResponseEntity.ok(chart);
    }

    @PostMapping
    public ResponseEntity<PuntajeModel> registrar(@RequestBody RegistrarPuntajeDTORequest request) {
        PuntajeModel puntaje = registrarPuntaje.ejecutar(request);
        return ResponseEntity.ok(puntaje);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactivar(@PathVariable Long id) {
        desactivarPuntaje.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}
