package backend.Aplicacion.pagination;

public record PageRequest(
        Integer size,
        Integer page
) {}
