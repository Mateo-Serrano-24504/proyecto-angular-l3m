package backend.Aplicacion.shared.pagination.mapper;

import backend.Aplicacion.shared.pagination.filter.FilterOperation;
import backend.Aplicacion.shared.pagination.filter.FilterRequest;
import backend.Aplicacion.shared.pagination.sort.SortDirection;
import backend.Aplicacion.shared.pagination.sort.SortRequest;
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
    private static List<SortRequest> getSort(PageRequestDTO dto) {
        return dto.sort() == null
                ? null
                : dto.sort()
                  .stream()
                  .map(PaginationDtoMapper::toSortRequest)
                  .toList();
    }

    private static FilterRequest toFilterRequest(String sort) {
        String[] split = sort.split(":");
        String selector = split[0];
        FilterOperation operation = FilterOperation.valueOf(
                split[1].toUpperCase()
        );
        return new FilterRequest(
                selector,
                operation,
                split[2]
        );
    }
    private static List<FilterRequest> getFilter(PageRequestDTO dto) {
        return dto.filter() == null || dto.filter().isEmpty()
                ? null
                : dto.filter()
                  .stream()
                  .map(PaginationDtoMapper::toFilterRequest)
                  .distinct()
                  .toList();
    }

    public static PageRequest toPageRequest(PageRequestDTO dto) {
        return new PageRequest(
                dto.size(),
                dto.index(),
                PaginationDtoMapper.getSort(dto),
                PaginationDtoMapper.getFilter(dto)
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
