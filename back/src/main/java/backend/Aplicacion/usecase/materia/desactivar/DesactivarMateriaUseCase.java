package backend.Aplicacion.usecase.materia.desactivar;

import backend.Dominio.puertos.in.materia.DesactivarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DesactivarMateriaUseCase implements DesactivarMateria {
    private final MateriaRepositoryPort repositoryPort;

    @Override
    public void desactivar(Long id) {
        repositoryPort.eliminar(id);
    }
}
