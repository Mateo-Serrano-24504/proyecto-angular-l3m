package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.ListarMateriaDTOResponse;

import java.util.List;

public interface ListarMateriaPort {
    List<ListarMateriaDTOResponse> ejecutar();
}
