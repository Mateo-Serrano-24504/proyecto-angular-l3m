package backend.Infraestructura.output.persistencia.adapater.puntaje;

import backend.Infraestructura.output.persistencia.mapper.puntaje.PuntajeMapper;
import backend.Infraestructura.output.persistencia.specification.PuntajeTieneEstudianteIdSpecification;
import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;
import backend.Infraestructura.output.persistencia.repository.estudiante.EstudianteJpaRepository;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import backend.Infraestructura.output.persistencia.repository.puntaje.PuntajeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
@Transactional
public class PuntajeAdapter implements PuntajeRepositoryPort {

    private final PuntajeJpaRepository puntajeJpaRepository;
    private final EstudianteJpaRepository estudianteJpaRepository;
    private final MateriaJpaRepository materiaJpaRepository;

    @Override
    public PuntajeModel guardar(PuntajeModel puntaje, Long materiaId, Long estudianteId) {

        EstudianteEntity estudiante = estudianteJpaRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        MateriaEntity materia = materiaJpaRepository.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        PuntajeEntity entity = PuntajeMapper.toEntity(puntaje, materia, estudiante);
        PuntajeEntity saved = puntajeJpaRepository.save(entity);

        return PuntajeMapper.toModel(saved);
    }

    @Override
    public List<PuntajeModel> buscarPorIdDeAlumno(Long id) {
        return this.puntajeJpaRepository
                .findAll(
                        PuntajeTieneEstudianteIdSpecification.hasEstudianteId(id)
                )
                .stream()
                .map(PuntajeMapper::toModel)
                .toList();
    }

    @Override
    public void desactivar(Long id) {
        PuntajeEntity entity = this.puntajeJpaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Puntaje de id " + id + " no existe"));
        entity.setActivo(false);
    }
}
