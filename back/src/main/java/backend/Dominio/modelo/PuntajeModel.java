package backend.Dominio.modelo;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PuntajeModel {
    private Long id;
    private double valor;
    private EstudianteModel estudiante;
    private MateriaModel materia;
    private LocalDateTime fechaPuntaje;

    public PuntajeModel(Long id, double valor, EstudianteModel estudiante, MateriaModel materia, LocalDateTime fechaPuntaje) {
        this.id = id;
        this.valor = valor;
        this.estudiante = estudiante;
        this.materia = materia;
        this.fechaPuntaje = fechaPuntaje;
    }
    public void validar() {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("El puntaje debe estar entre 0 y 10");
        }
    }


}
