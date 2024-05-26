package com.example.proyectobasesspring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class GrupoEstudianteId implements Serializable {
    private static final long serialVersionUID = -1395679315594267809L;
    @Column(name = "ID_ESTUDIANTE", nullable = false, length = 10)
    private String idEstudiante;

    @Column(name = "ID_GRUPO", nullable = false)
    private Long idGrupo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GrupoEstudianteId entity = (GrupoEstudianteId) o;
        return Objects.equals(this.idEstudiante, entity.idEstudiante) &&
                Objects.equals(this.idGrupo, entity.idGrupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudiante, idGrupo);
    }

}