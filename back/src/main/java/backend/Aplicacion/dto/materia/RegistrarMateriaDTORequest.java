package backend.Aplicacion.dto.materia;

import jakarta.validation.constraints.NotNull;

public record RegistrarMateriaDTORequest(

        @NotNull(message = "nombre es requerido")
        String nombre
) {
}
