package com.example.proyectobasesspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "USUARIOS")
public class Usuario {
    @Id
    @Column(name = "ID_USUARIO", nullable = false, length = 10)
    private String idUsuario;

    @Column(name = "CONTRASENA", nullable = false)
    private String contrasena;

    @Column(name = "CORREO", nullable = false, length = 50)
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_TIPO_USUARIO", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoUsuario idTipoUsuario;

}