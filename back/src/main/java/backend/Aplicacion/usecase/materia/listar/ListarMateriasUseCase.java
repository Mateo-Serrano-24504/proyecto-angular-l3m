package backend.Aplicacion.usecase.materia.listar;


import backend.Aplicacion.dto.materia.ListarMateriaDTOResponse;
import backend.Aplicacion.mapper.materiaMapper.MateriaMapper;
import backend.Dominio.puertos.in.materia.ListarMaterias;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarMateriasUseCase implements ListarMaterias {

    private final MateriaRepositoryPort materiaRepositoryPort;

    @Override
    public List<ListarMateriaDTOResponse> ejecutar() {
        return materiaRepositoryPort.listar()
                .stream()
                .map(MateriaMapper::toDto)
                .toList();
    }
}