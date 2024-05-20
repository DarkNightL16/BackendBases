package com.example.proyectobasesspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "HORARIOS")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "horario_seq_gen")
    @SequenceGenerator(name = "horario_seq_gen", sequenceName = "horario_seq", allocationSize = 1, initialValue = 26)
    @Column(name = "ID_HORARIO", nullable = false)
    private Long id;

    @Column(name = "DIA", nullable = false)
    private LocalDate dia;

    @Column(name = "HORA_INICIO", nullable = false)
    private Timestamp horaInicio;

    @Column(name = "HORA_FIN", nullable = false)
    private Timestamp horaFin;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "EXAMENES_ID_EXAMEN", nullable = false)
    @JsonIgnoreProperties({"idContenido", "profesoresUsuariosIdUsuario", "gruposIdGrupo"})
    private Examen examenesIdExamen;

}