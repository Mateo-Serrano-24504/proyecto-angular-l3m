package backend.Infraestructura.output.persistencia.mapper.pagination;

import backend.Aplicacion.shared.pagination.PageRequest;
import backend.Aplicacion.shared.pagination.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PaginationMapper {

    public static Pageable toPageable(PageRequest pageRequest) {
        return org.springframework.data.domain.PageRequest.of(
                pageRequest.page(),
                pageRequest.size()
        );
    }
    public static <T> PageResponse<T> toPageResponse(Page<T> page) {
        return new PageResponse<>(
                page.getSize(),
                page.getNumber(),
                page.getTotalPages(),
                page.getContent()
        );
    }
}
