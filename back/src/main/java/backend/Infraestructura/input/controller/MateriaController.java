package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.materia.MateriaDTOResponse;
import backend.Aplicacion.dto.materia.MateriaDTORequest;
import backend.Aplicacion.shared.pagination.dto.PageRequestDTO;
import backend.Aplicacion.shared.pagination.dto.PageResponseDTO;
import backend.Dominio.puertos.in.materia.ActualizarMateria;
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
    private final ActualizarMateria actualizarMateria;

    @PostMapping
    public ResponseEntity<Long> creaMateria(@RequestBody MateriaDTORequest req){
        Long id = registrarMateria.ejecutar(req);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactivarMateria(@PathVariable Long id) {
        desactivarMateria.desactivar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public PageResponseDTO<MateriaDTOResponse> listar(PageRequestDTO dto) {
        return this.listarMateriasPort.listarPagina(dto);
    }

    @GetMapping("/todos")
    public List<MateriaDTOResponse> listarTdos() {
        return this.listarMateriasPort.listarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaDTOResponse> actualizarMateria(
            @PathVariable Long id,
            @RequestBody MateriaDTORequest dto
    ) {
        MateriaDTOResponse materia = actualizarMateria.ejecutar(id, dto);
        return ResponseEntity.ok(materia);
    }
}
