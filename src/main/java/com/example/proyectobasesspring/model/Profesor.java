package com.example.proyectobasesspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "PROFESORES")
public class Profesor {
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

}