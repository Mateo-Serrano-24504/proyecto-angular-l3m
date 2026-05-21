package backend.Aplicacion.shared.pagination;

import java.util.List;
import java.util.function.Function;

public record PageResponse<T> (
        Integer size,
        Integer index,
        Integer pageCount,
        List<T> items
) {
    public <U> PageResponse<U> map(Function<T, U> mapper) {
        return new PageResponse<>(
                size,
                index,
                pageCount,
                items.stream()
                        .map(mapper)
                        .toList()
        );
    }
}
