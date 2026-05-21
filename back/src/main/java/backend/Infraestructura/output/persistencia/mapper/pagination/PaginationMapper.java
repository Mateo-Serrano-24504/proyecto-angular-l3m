package backend.Infraestructura.output.persistencia.mapper.pagination;

import backend.Aplicacion.shared.pagination.PageRequest;
import backend.Aplicacion.shared.pagination.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PaginationMapper {

    public static Pageable toPageable(PageRequest pageRequest) {
        return org.springframework.data.domain.PageRequest.of(
                pageRequest.page(),
                pageRequest.size(),
                SortMapper.toPageableSort(pageRequest.sortRequests())
        );
    }
    public static <T> PageResponse<T> toPageResponse(Page<T> page, PageRequest pageRequest) {
        return new PageResponse<>(
                page.getSize(),
                page.getNumber(),
                page.getTotalPages(),
                pageRequest.sortRequests(),
                pageRequest.filterRequests(),
                page.getContent()
        );
    }
}
