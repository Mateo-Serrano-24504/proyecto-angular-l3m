package backend.Dominio.puertos.out.materia;

import backend.Dominio.modelo.MateriaModel;

import java.util.List;

public interface MateriaRepositoryPort {
    MateriaModel guardar(MateriaModel materia);
    void eliminar(Long id);
    List<MateriaModel> listar();
    MateriaModel buscarPorId(Long id);
}
