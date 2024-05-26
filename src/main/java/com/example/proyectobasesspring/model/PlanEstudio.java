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
@Table(name = "PLANES_ESTUDIO")
public class PlanEstudio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plan_estudio_seq_gen")
    @SequenceGenerator(name = "plan_estudio_seq_gen", sequenceName = "plan_estudio_seq", allocationSize = 1, initialValue = 26)
    @Column(name = "ID_PLAN", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 40)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "CURSOS_ID_CURSO", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Curso cursosIdCurso;

}