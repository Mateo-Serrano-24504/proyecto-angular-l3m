package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.materia.ListarMateriaDTOResponse;
import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Dominio.puertos.in.materia.DesactivarMateria;
import backend.Dominio.puertos.in.materia.ListarMateriaPort;
import backend.Dominio.puertos.in.materia.RegistrarMateria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
@RequiredArgsConstructor
@CrossOrigin(origins= "*")
public class MateriaController {

    private final RegistrarMateria registrarMateria;
    private final DesactivarMateria desactivarMateria;
    private final ListarMateriaPort listarMateriasPort;

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

    @GetMapping
    public List<ListarMateriaDTOResponse> listar() {
        return this.listarMateriasPort.ejecutar();
    }
}
