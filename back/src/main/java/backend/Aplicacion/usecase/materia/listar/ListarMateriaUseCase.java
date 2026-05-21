package backend.Aplicacion.usecase.materia.listar;

import backend.Aplicacion.dto.materia.ListarMateriaDTOResponse;
import backend.Aplicacion.mapper.materia.ListarMateriasMapper;
import backend.Dominio.puertos.in.materia.ListarMateriaPort;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarMateriaUseCase implements ListarMateriaPort {

    private final MateriaRepositoryPort repository;
    private final ListarMateriasMapper mapper;

    @Override
    public List<ListarMateriaDTOResponse> ejecutar() {
        return this.repository.listar().stream().map(mapper::toDto).toList();
    }
}
