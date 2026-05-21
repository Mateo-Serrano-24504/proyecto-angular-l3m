package backend.Aplicacion.shared.pagination.filter;

public record FilterRequest(
        String selector,
        FilterOperation operation,
        String value
) {}
