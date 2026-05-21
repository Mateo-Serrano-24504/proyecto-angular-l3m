package backend.Infraestructura.output.persistencia.mapper.pagination;

import backend.Aplicacion.shared.pagination.sort.SortRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class SortMapper {

    private static Sort.Order toOrder(
            SortRequest sortRequest
    ) {
        Sort.Direction direction = switch (sortRequest.direction()) {
            case ASC -> Sort.Direction.ASC;
            case DESC -> Sort.Direction.DESC;
        };
        return new Sort.Order(
                direction,
                sortRequest.selector()
        );
    }

    public static Sort toPageableSort(
            List<SortRequest> sortRequests
    ) {
        if (sortRequests == null || sortRequests.isEmpty()) {
            return Sort.unsorted();
        }

        List<Sort.Order> orders = sortRequests.stream()
                .filter(sort ->
                        sort.selector() != null &&
                        !sort.selector().isBlank()
                )
                .map(SortMapper::toOrder)
                .toList();
        return Sort.by(orders);
    }
}
