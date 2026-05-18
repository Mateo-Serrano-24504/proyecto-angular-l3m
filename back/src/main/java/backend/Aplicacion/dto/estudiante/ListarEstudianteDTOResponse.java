package backend.Aplicacion.dto.estudiante;

public record ListarEstudianteDTOResponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        Integer dni
) {}
