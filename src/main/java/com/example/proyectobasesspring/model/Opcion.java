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
@Table(name = "OPCIONES")
public class Opcion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opcion_seq_gen")
    @SequenceGenerator(name = "opcion_seq_gen", sequenceName = "opcion_seq", allocationSize = 1, initialValue = 27)
    @Column(name = "ID_OPCION", nullable = false)
    private Long id;

    @Column(name = "TEXTO", nullable = false, length = 500)
    private String texto;

    @Column(name = "RESPUESTA", nullable = false, length = 700)
    private String respuesta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PREGUNTAS_ID_PREGUNTA", nullable = false)
    @JsonIgnoreProperties({"idContenido", "idTipoPregunta", "idProfesor", "idPreguntaCompuesta"})
    private Pregunta preguntasIdPregunta;

    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "OPCIONES_ID_OPCION")
    @JsonIgnoreProperties({"preguntasIdPregunta", "opcionesIdOpcion"})
    private Opcion opcionesIdOpcion;

}