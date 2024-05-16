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
@Table(name = "HORARIOS")
public class Horario {
    @Id
    @Column(name = "ID_HORARIO", nullable = false)
    private Long id;

    @Column(name = "DIA", nullable = false)
    private LocalDate dia;

    @Column(name = "HORA_INICIO", nullable = false)
    private LocalDate horaInicio;

    @Column(name = "HORA_FIN", nullable = false)
    private LocalDate horaFin;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "EXAMENES_ID_EXAMEN", nullable = false)
    private Examen examenesIdExamen;

}