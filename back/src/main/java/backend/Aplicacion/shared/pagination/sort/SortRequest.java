package backend.Aplicacion.shared.pagination.sort;

public record SortRequest (
        String selector,
        SortDirection direction
) {}
