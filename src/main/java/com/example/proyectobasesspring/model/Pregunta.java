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

    @Column(name = "PROFESORES_USUARIOS_ID_USUARIO", nullable = false, length = 10)
    private String profesoresUsuariosIdUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "TIPOS_PREGUNTAS_TIPO", nullable = false)
    private TiposPregunta tiposPreguntasTipo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PROFESOR", nullable = false)
    private Profesore idProfesor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PREGUNTA_COMPUESTA", nullable = false)
    private Pregunta idPreguntaCompuesta;

}