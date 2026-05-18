package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.estudiante.ListarEstudianteDTORsponse;
import backend.Aplicacion.dto.estudiante.ObtenerEstudiantePorIdDTOResponse;
import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Aplicacion.dto.paginacion.PageRequestDTO;
import backend.Aplicacion.dto.paginacion.PageResponseDTO;
import backend.Aplicacion.usecase.estudiante.registrar.RegistrarEstudianteUseCase;
import backend.Dominio.puertos.in.Student.ListarEstudiantesPort;
import backend.Dominio.puertos.in.Student.ObtenerEstudiantePorIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EstudianteController {

    private final RegistrarEstudianteUseCase registrarEstudianteUseCase;
    private final ListarEstudiantesPort listarEstudiantesPort;
    private final ObtenerEstudiantePorIdPort obtenerEstudiantePorId;

    @PostMapping
    public ResponseEntity<Long> crearEstudiante(@RequestBody RegistrarEstudianteDTORequest req) {
        Long id = registrarEstudianteUseCase.ejecutar(req);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public PageResponseDTO<ListarEstudianteDTORsponse> listar(PageRequestDTO dto) {
        return this.listarEstudiantesPort.ejecutar(dto);
    }

    @GetMapping("/{id}")
    public ObtenerEstudiantePorIdDTOResponse obtenerEstudiantePorId(@PathVariable Long id) {
        return this.obtenerEstudiantePorId.ejecutar(id);
    }
}
