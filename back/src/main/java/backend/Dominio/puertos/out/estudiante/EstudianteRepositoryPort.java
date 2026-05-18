package backend.Dominio.puertos.out.estudiante;

import backend.Aplicacion.pagination.PageRequest;
import backend.Aplicacion.pagination.PageResponse;
import backend.Dominio.modelo.EstudianteModel;

public interface EstudianteRepositoryPort {
    EstudianteModel guardar(EstudianteModel estudentiante);
    EstudianteModel obtenerPorId(Long id);
    PageResponse<EstudianteModel> listar(PageRequest request);
}
