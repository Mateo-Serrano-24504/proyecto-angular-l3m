package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.MateriaDTOResponse;
import backend.Aplicacion.shared.pagination.dto.PageRequestDTO;
import backend.Aplicacion.shared.pagination.dto.PageResponseDTO;

import java.util.List;

public interface ListarMateriaPort {
    PageResponseDTO<MateriaDTOResponse> ejecutar(PageRequestDTO dto);
}
