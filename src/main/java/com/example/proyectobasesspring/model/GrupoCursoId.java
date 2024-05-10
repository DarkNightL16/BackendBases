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
public class GrupoCursoId implements Serializable {
    private static final long serialVersionUID = -9174414898465398108L;
    @Column(name = "GRUPOS_ID_GRUPO", nullable = false)
    private Long gruposIdGrupo;

    @Column(name = "CURSOS_ID_CURSO", nullable = false)
    private Long cursosIdCurso;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GrupoCursoId entity = (GrupoCursoId) o;
        return Objects.equals(this.gruposIdGrupo, entity.gruposIdGrupo) &&
                Objects.equals(this.cursosIdCurso, entity.cursosIdCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gruposIdGrupo, cursosIdCurso);
    }

}