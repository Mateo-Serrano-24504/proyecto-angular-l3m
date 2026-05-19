package backend.Dominio.modelo;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PuntajeModel {
    private Long id;
    private double valor;
    private EstudianteModel estudiante;
    private MateriaModel materia;

    public PuntajeModel(Integer valor, EstudianteModel estudiante, MateriaModel materia) {
        this.valor = valor;
        this.estudiante = estudiante;
        this.materia = materia;
    }


    public void validar() {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("El puntaje debe estar entre 0 y 10");
        }
    }


}
