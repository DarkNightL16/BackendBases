package com.example.proyectobasesspring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "examen_presentado_seq_gen")
    @SequenceGenerator(name = "examen_presentado_seq_gen", sequenceName = "examen_presentado_seq", allocationSize = 1, initialValue = 26)
    @Column(name = "ID_PRESENTACION", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "EXAMENES_ID_EXAMEN", nullable = false)
    @JsonIgnoreProperties({"idContenido", "profesoresUsuariosIdUsuario", "gruposIdGrupo"})
    private Examen examenesIdExamen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ESTUDIANTES_ID_USUARIO", nullable = false)
    @JsonIgnoreProperties({"usuarios", "gruposIdGrupo"})
    private Estudiante estudiantesIdUsuario;

    @Column(name = "FECHA_PRESENTACION", nullable = false)
    private LocalDate fechaPresentacion;

    @Column(name = "DURACION", nullable = false)
    private Long duracion;

    @Column(name = "CALIFICACION", nullable = false)
    private Long calificacion;

}