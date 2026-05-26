package backend.Dominio.puertos.out.materia;

import backend.Aplicacion.dto.materia.MateriaDTOResponse;
import backend.Aplicacion.shared.pagination.PageRequest;
import backend.Aplicacion.shared.pagination.PageResponse;
import backend.Aplicacion.shared.pagination.dto.PageResponseDTO;
import backend.Dominio.modelo.MateriaModel;


public interface MateriaRepositoryPort {
    MateriaModel guardar(MateriaModel materia);
    void eliminar(Long id);
    PageResponse<MateriaModel> listar(PageRequest dto);
    MateriaModel buscarPorId(Long id);
}
