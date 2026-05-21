package backend.Infraestructura.output.persistencia.entity.puntaje;

import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "puntajes")
public class PuntajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor")
    private double valor;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private EstudianteEntity estudiante;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private MateriaEntity materia;

    @Column(name = "fecha_puntaje", nullable = false)
    private LocalDateTime fechaPuntaje;
}
