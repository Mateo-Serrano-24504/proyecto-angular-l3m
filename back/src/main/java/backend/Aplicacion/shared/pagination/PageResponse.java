package backend.Aplicacion.shared.pagination;

import backend.Aplicacion.shared.pagination.filter.FilterRequest;
import backend.Aplicacion.shared.pagination.sort.SortRequest;

import java.util.List;
import java.util.function.Function;

public record PageResponse<T> (
        Integer size,
        Integer index,
        Integer pageCount,
        List<SortRequest> sortRequests,
        List<FilterRequest> filterRequests,
        List<T> items
) {
    public <U> PageResponse<U> map(Function<T, U> mapper) {
        return new PageResponse<>(
                size,
                index,
                pageCount,
                sortRequests,
                filterRequests,
                items.stream()
                        .map(mapper)
                        .toList()
        );
    }
}
