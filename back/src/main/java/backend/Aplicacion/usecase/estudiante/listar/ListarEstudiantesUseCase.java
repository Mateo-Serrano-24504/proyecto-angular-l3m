package backend.Aplicacion.usecase.estudiante.listar;

import backend.Aplicacion.dto.estudiante.ListarEstudianteDTORsponse;
import backend.Aplicacion.dto.paginacion.PageRequestDTO;
import backend.Aplicacion.dto.paginacion.PageResponseDTO;
import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Aplicacion.mapper.paginationMapper.PaginationDtoMapper;
import backend.Aplicacion.pagination.PageRequest;
import backend.Dominio.puertos.in.Student.ListarEstudiantesPort;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListarEstudiantesUseCase implements ListarEstudiantesPort {
    private final EstudianteRepositoryPort repository;

    @Override
    public PageResponseDTO<ListarEstudianteDTORsponse> ejecutar(PageRequestDTO dto) {
        PageRequest request = PaginationDtoMapper.toPageRequest(dto);
        return PaginationDtoMapper.toPageResponseDTO(
                this.repository
                        .listar(request)
                        .map(StudentMapper::toDto)
        );
    }
}
