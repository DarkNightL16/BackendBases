package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}