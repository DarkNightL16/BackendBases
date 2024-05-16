package com.example.proyectobasesspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "PREGUNTAS_EXAMEN")
public class PreguntasExaman {
    @EmbeddedId
    private PreguntasExamanId id;

    @MapsId("examenesIdExamen")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "EXAMENES_ID_EXAMEN", nullable = false)
    private Examen examenesIdExamen;

    @MapsId("preguntasIdPregunta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PREGUNTAS_ID_PREGUNTA", nullable = false)
    private Pregunta preguntasIdPregunta;

    @Column(name = "PORCENTAJE_PREGUNTA", nullable = false)
    private Long porcentajePregunta;

}