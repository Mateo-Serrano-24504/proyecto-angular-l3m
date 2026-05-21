package backend.Dominio.puertos.out.materia;

import backend.Dominio.modelo.MateriaModel;

import java.util.List;

public interface MateriaRepositoryPort {
    MateriaModel guardar(MateriaModel materia);
    List<MateriaModel> listar() ;
}
