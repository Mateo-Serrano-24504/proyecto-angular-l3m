package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;

public interface RegistrarMateria {
Long ejecutar (RegistrarMateriaDTORequest req);
}
