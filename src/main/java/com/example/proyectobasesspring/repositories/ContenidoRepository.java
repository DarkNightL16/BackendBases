package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
}