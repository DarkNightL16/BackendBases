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
@Table(name = "GRUPO_CURSO")
public class GrupoCurso {
    @EmbeddedId
    private GrupoCursoId id;

    @MapsId("gruposIdGrupo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "GRUPOS_ID_GRUPO", nullable = false)
    @JsonIgnoreProperties("profesoresUsuariosIdUsuario")
    private Grupo gruposIdGrupo;

    @MapsId("cursosIdCurso")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "CURSOS_ID_CURSO", nullable = false)
    private Curso cursosIdCurso;

}