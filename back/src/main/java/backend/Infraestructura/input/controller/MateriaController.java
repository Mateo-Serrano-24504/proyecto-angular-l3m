package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Dominio.puertos.in.materia.DesactivarMateria;
import backend.Dominio.puertos.in.materia.RegistrarMateria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/materias")
@RequiredArgsConstructor
@CrossOrigin(origins= "*")
public class MateriaController {

    private final RegistrarMateria registrarMateria;
    private final DesactivarMateria desactivarMateria;

    @PostMapping
    public ResponseEntity<Long> creaMateria(@RequestBody RegistrarMateriaDTORequest req){
        Long id = registrarMateria.ejecutar(req);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactivarMateria(@PathVariable Long id) {
        desactivarMateria.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}
