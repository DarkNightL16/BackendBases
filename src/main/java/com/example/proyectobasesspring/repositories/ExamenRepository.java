package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
}