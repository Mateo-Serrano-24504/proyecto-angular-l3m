package backend.Aplicacion.dto.puntaje;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegistrarPuntajeDTORequest(
        @NotNull(message = "Estudiante es requerido")
        Long estudianteId,

        @NotNull(message = "Materia requerido")
        Long materiaId,

        @NotNull(message = "Puntaje es requerido")
        double valor,

        @NotNull
        LocalDateTime fechaPuntaje
) {
}
