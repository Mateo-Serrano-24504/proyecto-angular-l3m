package backend.Aplicacion.mapper.paginationMapper;

import backend.Aplicacion.dto.paginacion.PageRequestDTO;
import backend.Aplicacion.dto.paginacion.PageResponseDTO;
import backend.Aplicacion.pagination.PageRequest;
import backend.Aplicacion.pagination.PageResponse;

public class PaginationDtoMapper {
    public static PageRequest toPageRequest(PageRequestDTO dto) {
        return new PageRequest(
                dto.size(),
                dto.index()
        );
    }
    public static <T> PageResponseDTO<T> toPageResponseDTO(PageResponse<T> pageResponse) {
        return new PageResponseDTO<>(
                pageResponse.size(),
                pageResponse.index(),
                pageResponse.pageCount(),
                pageResponse.items()
        );
    }
}
