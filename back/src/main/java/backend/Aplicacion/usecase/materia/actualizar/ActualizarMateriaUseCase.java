package backend.Aplicacion.usecase.materia.actualizar;

import backend.Aplicacion.dto.materia.MateriaDTORequest;
import backend.Aplicacion.dto.materia.MateriaDTOResponse;
import backend.Aplicacion.mapper.materia.MateriaDtoMapper;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.in.materia.ActualizarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ActualizarMateriaUseCase implements ActualizarMateria {
    private final MateriaDtoMapper mapper;
    private final MateriaRepositoryPort repository;

    @Override
    public MateriaDTOResponse ejecutar(Long id, MateriaDTORequest dto){
        MateriaModel materia = repository.buscarPorId(id);

        mapper.updateModel(dto, materia);

        MateriaModel actualizada = repository.guardar(materia);

        return mapper.toDto(actualizada);
    }

}
