package backend.Aplicacion.dto.materia;

import jakarta.validation.constraints.NotNull;

public record MateriaDTORequest(

        @NotNull(message = "nombre es requerido")
        String nombre
) {
}
