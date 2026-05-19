package backend.Aplicacion.dto.puntaje;

import jakarta.validation.constraints.NotNull;

public record RegistrarPuntajeDTORequest(
        @NotNull(message = "Estudiante es requerido")
        Long estudianteId,

        @NotNull(message = "Materia requerido")
        Long materiaId,

        @NotNull(message = "Puntaje es requerido")
        double valor
) {
}
