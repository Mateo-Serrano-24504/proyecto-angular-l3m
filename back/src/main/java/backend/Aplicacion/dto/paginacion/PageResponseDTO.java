package backend.Aplicacion.dto.paginacion;

import java.util.List;

public record PageResponseDTO<T>(
        Integer size,
        Integer index,
        Integer pageCount,
        List<T> items
) {}
