package backend.Aplicacion.usecase.materia.listar;

import backend.Aplicacion.dto.materia.MateriaDTOResponse;
import backend.Aplicacion.mapper.materia.MateriaDtoMapper;
import backend.Dominio.puertos.in.materia.ListarMateriaPort;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarMateriaUseCase implements ListarMateriaPort {

    private final MateriaRepositoryPort repository;
    private final MateriaDtoMapper mapper;

    @Override
    public List<MateriaDTOResponse> ejecutar() {
        return this.repository.listar().stream().map(mapper::toDto).toList();
    }
}
