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
@Table(name = "TEMAS")
public class Tema {
    @Id
    @Column(name = "ID_TEMA", nullable = false)
    private Long id;

    @Column(name = "DESCRIPCION", nullable = false, length = 40)
    private String descripcion;

}