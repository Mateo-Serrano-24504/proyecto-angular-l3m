package backend.Aplicacion.usecase.materia.listar;

import backend.Aplicacion.dto.materia.MateriaDTOResponse;
import backend.Aplicacion.mapper.materia.MateriaDtoMapper;
import backend.Aplicacion.shared.pagination.PageRequest;
import backend.Aplicacion.shared.pagination.dto.PageRequestDTO;
import backend.Aplicacion.shared.pagination.dto.PageResponseDTO;
import backend.Aplicacion.shared.pagination.mapper.PaginationDtoMapper;
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
    public PageResponseDTO<MateriaDTOResponse> listarPagina(PageRequestDTO dto) {
        PageRequest request = PaginationDtoMapper.toPageRequest(dto);
        return PaginationDtoMapper.toPageResponseDTO(
                this.repository
                        .listar(request)
                        .map(mapper::toDto)
        );
    }

    @Override
    public List<MateriaDTOResponse> listarTodos() {
        return this.repository
                .listarTodos()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
