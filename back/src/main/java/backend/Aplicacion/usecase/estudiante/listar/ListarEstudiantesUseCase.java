package backend.Aplicacion.usecase.estudiante.listar;

import backend.Aplicacion.dto.estudiante.listar.ListarEstudianteDTOResponse;
import backend.Aplicacion.shared.pagination.dto.PageRequestDTO;
import backend.Aplicacion.shared.pagination.dto.PageResponseDTO;
import backend.Aplicacion.mapper.estudiante.listar.ListarEstudiantesMapper;
import backend.Aplicacion.shared.pagination.mapper.PaginationDtoMapper;
import backend.Aplicacion.shared.pagination.PageRequest;
import backend.Dominio.puertos.in.estudiante.ListarEstudiantesPort;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListarEstudiantesUseCase implements ListarEstudiantesPort {
    private final EstudianteRepositoryPort repository;
    private final ListarEstudiantesMapper mapper;

    @Override
    public PageResponseDTO<ListarEstudianteDTOResponse> ejecutar(PageRequestDTO dto) {
        PageRequest request = PaginationDtoMapper.toPageRequest(dto);
        return PaginationDtoMapper.toPageResponseDTO(
                this.repository
                        .listar(request)
                        .map(mapper::toDto)
        );
    }
}
