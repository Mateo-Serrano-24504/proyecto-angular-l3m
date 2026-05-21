package backend.Infraestructura.output.persistencia.adapater.materiaAdapter;

import backend.Aplicacion.mapper.materiaMapper.MateriaMapper;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
public class MateriaRepositryAdapter implements MateriaRepositoryPort {

    private final MateriaJpaRepository materiaJpaRepository;


    @Override
    public List<MateriaModel> listar() {
        return materiaJpaRepository.findAll()
                .stream()
                .map(MateriaMapper::toModel)
                .toList();
    }
    @Override
    public MateriaModel guardar(MateriaModel materia) {
        MateriaEntity entity = MateriaMapper.toEntity(materia);
        MateriaEntity saved = materiaJpaRepository.save(entity);

        return MateriaMapper.toModel(saved);

    }
}
