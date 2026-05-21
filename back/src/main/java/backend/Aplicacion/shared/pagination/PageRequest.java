package backend.Aplicacion.shared.pagination;

import backend.Aplicacion.shared.pagination.filter.FilterRequest;
import backend.Aplicacion.shared.pagination.sort.SortRequest;

import java.util.List;

public record PageRequest(
        Integer size,
        Integer page,
        List<SortRequest> sortRequests,
        List<FilterRequest> filterRequests
) {}
