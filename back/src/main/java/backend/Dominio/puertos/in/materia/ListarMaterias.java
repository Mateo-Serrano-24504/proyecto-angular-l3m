package backend.Dominio.puertos.in.materia;

import java.util.List;

import backend.Aplicacion.dto.materia.ListarMateriaDTOResponse;

public interface ListarMaterias {
    
    List<ListarMateriaDTOResponse> ejecutar();
    
}
