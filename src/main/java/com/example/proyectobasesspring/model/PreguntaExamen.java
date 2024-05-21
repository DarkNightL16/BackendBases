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
@Table(name = "PREGUNTAS_EXAMEN")
public class PreguntaExamen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preguntas_examen_seq_gen")
    @SequenceGenerator(name = "preguntas_examen_seq_gen", sequenceName = "preguntas_examen_seq", allocationSize = 1, initialValue = 44)
    @Column(name = "ID_PREGUNTA_EXAMEN", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "EXAMENES_ID_EXAMEN", nullable = false)
    @JsonIgnoreProperties({"idContenido", "profesoresUsuariosIdUsuario", "gruposIdGrupo"})
    private Examen examenesIdExamen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PREGUNTAS_ID_PREGUNTA", nullable = false)
    @JsonIgnoreProperties({"idContenido", "idTipoPregunta","idProfesor", "idPreguntaCompuesta"})
    private Pregunta preguntasIdPregunta;

    @Column(name = "PORCENTAJE_PREGUNTA", nullable = false)
    private Long porcentajePregunta;

}