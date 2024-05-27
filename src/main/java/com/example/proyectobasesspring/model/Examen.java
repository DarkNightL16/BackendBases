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
@Table(name = "EXAMENES")
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "examen_seq_gen")
    @SequenceGenerator(name = "examen_seq_gen", sequenceName = "examen_seq", allocationSize = 1, initialValue = 26)
    @Column(name = "ID_EXAMEN", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "CANTIDAD_PREGUNTAS", nullable = false)
    private Long cantidadPreguntas;

    @Column(name = "DURACION", nullable = false)
    private Long duracion;

    @Column(name = "TIPO_EXAMEN", nullable = false, length = 30)
    private String tipoExamen;

    @Column(name = "PORCENTAJE_CURSO", nullable = false)
    private Long porcentajeCurso;

    @Column(name = "UMBRAL_APROBADO", nullable = false)
    private Long umbralAprobado;

    @Column(name = "ESTADO_PUBLICACION", nullable = false, length = 80)
    private String estadoPublicacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_CONTENIDO", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Contenido idContenido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PROFESORES_USUARIOS_ID_USUARIO", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Profesor profesoresUsuariosIdUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "GRUPOS_ID_GRUPO", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Grupo gruposIdGrupo;

    @Column(name = "CANTIDAD_PREGUNTAS_ESTUDIANTE")
    private Long cantidadPreguntasEstudiante;

    @Column(name = "ES_AUTOMATICO")
    private Boolean esAutomatico;

}