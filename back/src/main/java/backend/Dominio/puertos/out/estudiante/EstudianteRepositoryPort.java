package backend.Dominio.puertos.out.estudiante;

import backend.Aplicacion.shared.pagination.PageRequest;
import backend.Aplicacion.shared.pagination.PageResponse;
import backend.Dominio.modelo.EstudianteModel;

public interface EstudianteRepositoryPort {
    EstudianteModel guardar(EstudianteModel estudentiante);
    PageResponse<EstudianteModel> listar(PageRequest request);
    EstudianteModel buscarPorId(Long id);
    void desactivar(Long id);
}
