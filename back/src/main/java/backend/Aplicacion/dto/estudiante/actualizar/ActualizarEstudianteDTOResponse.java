package backend.Aplicacion.dto.estudiante.actualizar;

public record ActualizarEstudianteDTOResponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        Integer dni
) {}
