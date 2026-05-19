package backend.Aplicacion.dto.paginacion;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record PageRequestDTO (
        @Positive
        Integer size,
        @PositiveOrZero
        Integer index
) {}
