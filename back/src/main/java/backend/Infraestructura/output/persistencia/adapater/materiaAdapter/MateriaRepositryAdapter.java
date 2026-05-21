package backend.Infraestructura.output.persistencia.adapater.materiaAdapter;

import backend.Infraestructura.output.persistencia.mapper.materia.MateriaMapper;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@AllArgsConstructor
@Transactional
public class MateriaRepositryAdapter implements MateriaRepositoryPort {

    private final MateriaJpaRepository materiaJpaRepository;
    private final MateriaMapper mapper;

    @Override
    public MateriaModel guardar(MateriaModel materia) {
        MateriaEntity entity = mapper.toEntity(materia);
        MateriaEntity saved = materiaJpaRepository.save(entity);

        return mapper.toModel(saved);
    }

    @Override
    public void eliminar(Long id) {
        MateriaEntity entity = materiaJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia de id " + id + " no existe"));
        entity.setActivo(false);
    }
}
