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
@Table(name = "UNIDADES")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidad_seq_gen")
    @SequenceGenerator(name = "unidad_seq_gen", sequenceName = "unidad_seq", allocationSize = 1, initialValue = 26)
    @Column(name = "ID_UNIDAD", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PLANES_ESTUDIO_ID_PLAN", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PlanEstudio planEstudioIdPlan;

}