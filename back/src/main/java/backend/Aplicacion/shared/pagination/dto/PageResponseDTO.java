package backend.Aplicacion.shared.pagination.dto;

import java.util.List;

public record PageResponseDTO<T>(
        Integer size,
        Integer index,
        Integer pageCount,
        List<T> items
) {}
