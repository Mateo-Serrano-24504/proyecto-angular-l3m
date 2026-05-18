package backend.Aplicacion.dto.estudiante;

public record ListarEstudianteDTORsponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        Integer dni
) {}
