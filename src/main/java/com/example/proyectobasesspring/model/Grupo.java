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
@Table(name = "GRUPOS")
public class Grupo {
    @Id
    @Column(name = "ID_GRUPO", nullable = false)
    private Long id;

    @Column(name = "NOMBRE_GRUPO", nullable = false, length = 30)
    private String nombreGrupo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PROFESORES_USUARIOS_ID_USUARIO", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Profesor profesoresUsuariosIdUsuario;

}