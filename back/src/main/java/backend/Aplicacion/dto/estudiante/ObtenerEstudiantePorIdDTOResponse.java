package backend.Aplicacion.dto.estudiante;

public record ObtenerEstudiantePorIdDTOResponse (
        Long id,
        String nombre,
        String apellido,
        String email,
        Integer dni
) {}
