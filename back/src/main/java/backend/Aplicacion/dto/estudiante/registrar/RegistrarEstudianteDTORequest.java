package backend.Aplicacion.dto.estudiante.registrar;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegistrarEstudianteDTORequest(
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
