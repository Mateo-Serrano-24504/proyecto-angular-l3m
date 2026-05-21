package backend.Aplicacion.shared.pagination;

public record PageRequest(
        Integer size,
        Integer page
) {}
