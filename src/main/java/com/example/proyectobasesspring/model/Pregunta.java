package com.example.proyectobasesspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "PREGUNTAS")
public class Pregunta {
    @Id
    @Column(name = "ID_PREGUNTA", nullable = false)
    private Long id;

    @Column(name = "TEXTO_PREGUNTA", nullable = false, length = 300)
    private String textoPregunta;

    @Column(name = "PRIVACIDAD", nullable = false)
    private Long privacidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "TEMAS_ID_TEMA", nullable = false)
    private Tema temasIdTema;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_TIPO_PREGUNTA", nullable = false)
    private TiposPregunta idTipoPregunta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PROFESOR", nullable = false)
    private Profesor idProfesor;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PREGUNTA_COMPUESTA")
    private Pregunta idPreguntaCompuesta;

}