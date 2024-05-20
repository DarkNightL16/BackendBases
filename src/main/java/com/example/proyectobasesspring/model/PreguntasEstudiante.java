package com.example.proyectobasesspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "PREGUNTAS_ESTUDIANTE")
public class PreguntasEstudiante {
    @Id
    @Column(name = "ID_PREGUNTA_ESTUDIANTE", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "PREGUNTAS_EXM_ID_PREGUNTA", referencedColumnName = "PREGUNTAS_ID_PREGUNTA", nullable = false),
            @JoinColumn(name = "PREGUNTAS_EX_ID_EXAMEN", referencedColumnName = "EXAMENES_ID_EXAMEN", nullable = false)
    })
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private PreguntasExamen preguntasExamen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_PRESENTACION", nullable = false)
    private ExamenPresentado idPresentación;

}