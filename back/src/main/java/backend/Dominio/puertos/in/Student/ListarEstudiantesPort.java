package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.ListarEstudianteDTORsponse;
import backend.Aplicacion.dto.paginacion.PageRequestDTO;
import backend.Aplicacion.dto.paginacion.PageResponseDTO;

public interface ListarEstudiantesPort {
    PageResponseDTO<ListarEstudianteDTORsponse> ejecutar(PageRequestDTO dto);
}
