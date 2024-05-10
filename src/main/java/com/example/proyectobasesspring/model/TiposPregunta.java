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
@Table(name = "TIPOS_PREGUNTAS")
public class TiposPregunta {
    @Id
    @Column(name = "TIPO", nullable = false, length = 30)
    private String tipo;

    //TODO [JPA Buddy] generate columns from DB
}