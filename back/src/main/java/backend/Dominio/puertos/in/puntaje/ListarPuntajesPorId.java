package backend.Dominio.puertos.in.puntaje;

public interface ListarPuntajesPorId {
    List<ObtenerPuntajesPorEstudianteDniDTOResponse> ejecutar(Long estudianteId);

}
