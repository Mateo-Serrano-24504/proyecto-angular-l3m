package backend.Aplicacion.shared.pagination;

import java.util.List;

public record PageRequest(
        Integer size,
        Integer page,
        List<SortRequest> sortRequests
) {}
