package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.ListarEstudianteDTOResponse;
import backend.Aplicacion.dto.paginacion.PageRequestDTO;
import backend.Aplicacion.dto.paginacion.PageResponseDTO;

public interface ListarEstudiantesPort {
    PageResponseDTO<ListarEstudianteDTOResponse> ejecutar(PageRequestDTO dto);
}
