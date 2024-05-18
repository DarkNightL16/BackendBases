package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadRepository extends JpaRepository<Unidad, Long> {
}