package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.MateriaDTOResponse;

import java.util.List;

public interface ListarMateriaPort {
    List<MateriaDTOResponse> ejecutar();
}
