package com.example.proyectobasesspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "PREGUNTAS_ESTUDIANTE")
public class PreguntaEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preguntas_estudiante_seq_gen")
    @SequenceGenerator(name = "preguntas_estudiante_seq_gen", sequenceName = "preguntas_estudiante_seq", allocationSize = 1, initialValue = 44)
    @Column(name = "ID_PREGUNTA_ESTUDIANTE", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PRESENTACION", nullable = false)
    private ExamenPresentado idPresentacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PREGUNTA_EXAMEN", nullable = false)
    private PreguntaExamen idPreguntaExamen;

}