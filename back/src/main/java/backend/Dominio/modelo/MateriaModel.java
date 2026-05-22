package backend.Dominio.modelo;

import backend.Aplicacion.shared.exception.InactiveEntityException;

public class MateriaModel {

    private Long id;
    private String nombre;
    private Boolean active;

    public MateriaModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void activar() {
        this.active = true;
    }

    public MateriaModel ifInactiveThrow() {
        if (!active) {
            throw new InactiveEntityException("Materia inactiva");
        }
        return this;
    }
}
