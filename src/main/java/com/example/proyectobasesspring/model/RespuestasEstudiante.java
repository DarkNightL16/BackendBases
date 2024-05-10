package com.example.proyectobasesspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "RESPUESTAS_ESTUDIANTE")
public class RespuestasEstudiante {
    @Id
    @Column(name = "ID_RESPUESTA_ESTUDIANTE", nullable = false)
    private Long id;

    @Column(name = "TEXTO", nullable = false, length = 600)
    private String texto;

    @Column(name = "RESPUESTA", nullable = false, length = 600)
    private String respuesta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PREGUNTA_ESTUDIANTE", nullable = false)
    private PreguntasEstudiante idPreguntaEstudiante;

}