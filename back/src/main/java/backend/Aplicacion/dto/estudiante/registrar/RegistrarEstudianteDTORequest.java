package backend.Aplicacion.dto.estudiante.registrar;

import jakarta.validation.constraints.*;

public record RegistrarEstudianteDTORequest(
        @NotBlank(message = "Nombre es requerido")
        @Size(max = 100, message = "Nombre demasiado largo")
        String nombre,

        @NotBlank(message = "Nombre es requerido")
        @Size(max = 100, message = "Apellido demasiado largo")
        String apellido,

        @NotBlank(message = "Email es requerido")
        @Email(message = "Email inválido")
        @Size(max = 255, message = "Email demasiado largo")
        String email,

        @Positive(message = "DNI inválido")
        int dni
) {
}
