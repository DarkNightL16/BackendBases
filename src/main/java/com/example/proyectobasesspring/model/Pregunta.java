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
@Table(name = "PREGUNTAS")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pregunta_seq_gen")
    @SequenceGenerator(name = "pregunta_seq_gen", sequenceName = "pregunta_seq", allocationSize = 1, initialValue = 28)
    @Column(name = "ID_PREGUNTA", nullable = false)
    private Long id;

    @Column(name = "TEXTO_PREGUNTA", nullable = false, length = 300)
    private String textoPregunta;

    @Column(name = "PRIVACIDAD", nullable = false)
    private Long privacidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_CONTENIDO", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Contenido idContenido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_TIPO_PREGUNTA", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TiposPregunta idTipoPregunta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PROFESOR", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Profesor idProfesor;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PREGUNTA_COMPUESTA")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pregunta idPreguntaCompuesta;

    @Column(name = "VALOR")
    private Long valor;

    @Column(name = "CANTIDAD_SUBPREGUNTAS")
    private Long cantidadSubpreguntas;

}