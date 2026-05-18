package backend.Aplicacion.dto.estudiante;

import jakarta.validation.constraints.NotNull;

public record ActualizarEstudianteDTORequest(
        @NotNull(message = "Nombre es requerido")
        String nombre,

        @NotNull(message = "Apellido es requerido")
        String apellido,

        @NotNull(message = "Email es requerido")
        String email,

        @NotNull(message = "Dni es requerido")
        int dni
) {
}
