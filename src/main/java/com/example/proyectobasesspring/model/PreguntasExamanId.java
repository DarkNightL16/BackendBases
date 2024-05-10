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
public class PreguntasExamanId implements Serializable {
    private static final long serialVersionUID = 5737881598449142968L;
    @Column(name = "EXAMENES_ID_EXAMEN", nullable = false)
    private Long examenesIdExamen;

    @Column(name = "PREGUNTAS_ID_PREGUNTA", nullable = false)
    private Long preguntasIdPregunta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PreguntasExamanId entity = (PreguntasExamanId) o;
        return Objects.equals(this.examenesIdExamen, entity.examenesIdExamen) &&
                Objects.equals(this.preguntasIdPregunta, entity.preguntasIdPregunta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examenesIdExamen, preguntasIdPregunta);
    }

}