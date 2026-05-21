package backend.Aplicacion.shared.pagination.mapper;

import backend.Aplicacion.shared.pagination.dto.PageRequestDTO;
import backend.Aplicacion.shared.pagination.dto.PageResponseDTO;
import backend.Aplicacion.shared.pagination.PageRequest;
import backend.Aplicacion.shared.pagination.PageResponse;

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
