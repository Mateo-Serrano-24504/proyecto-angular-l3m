package backend.Aplicacion.dto.estudiante.listar;

public record ListarEstudianteDTOResponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        Integer dni
) {}
