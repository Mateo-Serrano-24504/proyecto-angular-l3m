package backend.Aplicacion.shared.pagination.mapper;

import backend.Aplicacion.shared.pagination.SortDirection;
import backend.Aplicacion.shared.pagination.SortRequest;
import backend.Aplicacion.shared.pagination.dto.PageRequestDTO;
import backend.Aplicacion.shared.pagination.dto.PageResponseDTO;
import backend.Aplicacion.shared.pagination.PageRequest;
import backend.Aplicacion.shared.pagination.PageResponse;

import java.util.List;

public class PaginationDtoMapper {
    private static SortRequest toSortRequest(String sort) {
        String[] split = sort.split(":");
        String selector = split[0];
        SortDirection direction =
                split.length > 1
                        ? SortDirection.valueOf(
                        split[1].toUpperCase()
                )
                        : SortDirection.ASC;
        return new SortRequest(
                selector,
                direction
        );
    }

    public static PageRequest toPageRequest(PageRequestDTO dto) {
        List<SortRequest> sorts = dto.sort() == null
                ? null
                : dto.sort()
                  .stream()
                  .map(PaginationDtoMapper::toSortRequest)
                  .toList();
        System.out.println("SORTS: " + sorts);
        return new PageRequest(
                dto.size(),
                dto.index(),
                sorts
        );
    }
    public static <T> PageResponseDTO<T> toPageResponseDTO(PageResponse<T> pageResponse) {
        return new PageResponseDTO<>(
                pageResponse.size(),
                pageResponse.index(),
                pageResponse.pageCount(),
                pageResponse.sortRequests(),
                pageResponse.items()
        );
    }
}
