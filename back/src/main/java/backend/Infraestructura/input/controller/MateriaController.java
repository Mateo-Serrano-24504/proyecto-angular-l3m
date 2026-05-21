package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.materia.ListarMateriaDTOResponse;
import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Aplicacion.usecase.materia.registrar.RegistrarMateriaUseCase;
import backend.Dominio.puertos.in.materia.ListarMaterias;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/materias")
@RequiredArgsConstructor
@CrossOrigin(origins= "*")
public class MateriaController {

    private final RegistrarMateriaUseCase registrarMateriaUseCase;
    private final ListarMaterias listarMaterias;

    @GetMapping("/listar")
    public ResponseEntity<List<ListarMateriaDTOResponse>> listarMaterias() {
        return ResponseEntity.ok(listarMaterias.ejecutar());
    }

    @PostMapping
    public ResponseEntity<Long> creaMateria(@RequestBody RegistrarMateriaDTORequest req){
        Long id = registrarMateriaUseCase.ejecutar(req);
        return  ResponseEntity.ok(id);
    }

}
