package backend.Aplicacion.shared.pagination;

public record SortRequest (
        String selector,
        SortDirection direction
) {}
