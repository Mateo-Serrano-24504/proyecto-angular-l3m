package backend.Aplicacion.shared.pagination.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public record PageRequestDTO (
        @Positive
        Integer size,
        @PositiveOrZero
        Integer index,

        List<String> sort,
        List<String> filter
) {}
