package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Aplicacion.usecase.materia.registrar.RegistrarMateriaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/materias")
@RequiredArgsConstructor
@CrossOrigin(origins= "*")
public class MateriaController {

    private final RegistrarMateriaUseCase registrarMateriaUseCase;


    @PostMapping
    public ResponseEntity<Long> creaMateria(@RequestBody RegistrarMateriaDTORequest req){
        Long id = registrarMateriaUseCase.ejecutar(req);
        return  ResponseEntity.ok(id);
    }

}
