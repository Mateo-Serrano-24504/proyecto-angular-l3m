package backend.Aplicacion.usecase.materia.registrar;

import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.in.materia.RegistrarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarMateriaUseCase implements RegistrarMateria {

   private final MateriaRepositoryPort materiaRepositoryPortepository;

    @Override
    public Long ejecutar(RegistrarMateriaDTORequest req) {
        MateriaModel materia = new MateriaModel();
        materia.setNombre(req.nombre());
        materia.activar();

        MateriaModel materiaGuardada = materiaRepositoryPortepository.guardar(materia);
       return materiaGuardada.getId();
    }


}
