package com.example.proyectobasesspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "ESTUDIANTES")
public class Estudiante {
    @Id
    @Column(name = "USUARIOS_ID_USUARIO", nullable = false, length = 10)
    private String usuariosIdUsuario;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "USUARIOS_ID_USUARIO", nullable = false)
    private Usuario usuarios;

    @Column(name = "NOMBRE", nullable = false, length = 40)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 40)
    private String apellido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "GRUPOS_ID_GRUPO", nullable = false)
    private Grupo gruposIdGrupo;

}