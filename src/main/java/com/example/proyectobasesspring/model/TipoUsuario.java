package com.example.proyectobasesspring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TIPO_USUARIO")
public class TipoUsuario {
    @Id
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;

    //TODO [JPA Buddy] generate columns from DB
}