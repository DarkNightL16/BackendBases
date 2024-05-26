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
@Table(name = "CONTENIDO")
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contenido_seq_gen")
    @SequenceGenerator(name = "contenido_seq_gen", sequenceName = "contenido_seq", allocationSize = 1, initialValue = 26)
    @Column(name = "ID_CONTENIDO", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 40)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "UNIDADES_ID_UNIDAD", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Unidad unidadesIdUnidad;

}