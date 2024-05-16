package com.example.proyectobasesspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "EXAMEN_PRESENTADO")
public class ExamenPresentado {
    @Id
    @Column(name = "\"ID_PRESENTACIÓN\"", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "EXAMENES_ID_EXAMEN", nullable = false)
    private Examen examenesIdExamen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ESTUDIANTES_ID_USUARIO", nullable = false)
    private Estudiante estudiantesIdUsuario;

    @Column(name = "FECHA_PRESENTACION", nullable = false)
    private LocalDate fechaPresentacion;

    @Column(name = "DURACION", nullable = false)
    private Long duracion;

    @Column(name = "CALIFICACION", nullable = false)
    private Long calificacion;

}