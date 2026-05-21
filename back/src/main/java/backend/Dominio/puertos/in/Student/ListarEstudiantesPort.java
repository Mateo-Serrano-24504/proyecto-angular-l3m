package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.listar.ListarEstudianteDTOResponse;
import backend.Aplicacion.shared.pagination.dto.PageRequestDTO;
import backend.Aplicacion.shared.pagination.dto.PageResponseDTO;

public interface ListarEstudiantesPort {
    PageResponseDTO<ListarEstudianteDTOResponse> ejecutar(PageRequestDTO dto);
}
