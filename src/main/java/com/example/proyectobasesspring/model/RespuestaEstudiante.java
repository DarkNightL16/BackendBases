package com.example.proyectobasesspring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "RESPUESTAS_ESTUDIANTE")
public class RespuestaEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "respuestas_estudiante_seq_gen")
    @SequenceGenerator(name = "respuestas_estudiante_seq_gen", sequenceName = "respuestas_estudiante_seq", allocationSize = 1, initialValue = 26)
    @Column(name = "ID_RESPUESTA_ESTUDIANTE", nullable = false)
    private Long id;

    @Column(name = "RESPUESTA", nullable = false, length = 600)
    private String respuesta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PREGUNTA_ESTUDIANTE", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PreguntaEstudiante idPreguntaEstudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_OPCION")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Opcion idOpcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_ESTUDIANTE")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estudiante idEstudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PREGUNTA")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pregunta idPregunta;

}