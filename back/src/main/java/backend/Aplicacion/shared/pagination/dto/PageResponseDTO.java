package backend.Aplicacion.shared.pagination.dto;

import backend.Aplicacion.shared.pagination.sort.SortRequest;

import java.util.List;

public record PageResponseDTO<T>(
        Integer size,
        Integer index,
        Integer pageCount,
        List<SortRequest> sortRequests,
        List<T> items
) {}
