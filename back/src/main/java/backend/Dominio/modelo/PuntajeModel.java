package backend.Dominio.modelo;


import java.time.LocalDateTime;

public class PuntajeModel {
    private Long id;
    private Double valor;
    private EstudianteModel estudiante;
    private MateriaModel materia;
    private Boolean activo;
    private LocalDateTime fechaPuntaje;
    public PuntajeModel() {}

    public void validar() {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("El puntaje debe estar entre 0 y 10");
        }
    }

    public LocalDateTime getFechaPuntaje() {
        return fechaPuntaje;
    }

    public void setFechaPuntaje(LocalDateTime fechaPuntaje) {
        this.fechaPuntaje = fechaPuntaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public EstudianteModel getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteModel estudiante) {
        this.estudiante = estudiante;
    }

    public MateriaModel getMateria() {
        return materia;
    }

    public void setMateria(MateriaModel materia) {
        this.materia = materia;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void activar() {
        activo = true;
    }
}
