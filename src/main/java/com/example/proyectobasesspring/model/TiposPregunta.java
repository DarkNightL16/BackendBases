package com.example.proyectobasesspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TIPOS_PREGUNTAS")
public class TiposPregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipos_pregunta_seq_gen")
    @SequenceGenerator(name = "tipos_pregunta_seq_gen", sequenceName = "tipos_pregunta_seq", allocationSize = 1, initialValue = 5)
    @Column(name = "ID_TIPO_PREGUNTA", nullable = false)
    private Long id;

    @Column(name = "TIPO", nullable = false, length = 30)
    private String tipo;

}