package backend.Dominio.puertos.out.estudiante;

import backend.Aplicacion.pagination.PageRequest;
import backend.Aplicacion.pagination.PageResponse;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.MateriaModel;

import java.util.List;

public interface EstudianteRepositoryPort {
    EstudianteModel guardar(EstudianteModel estudentiante);
    PageResponse<EstudianteModel> listar(PageRequest request);
    EstudianteModel buscarPorId(Long id);
}
