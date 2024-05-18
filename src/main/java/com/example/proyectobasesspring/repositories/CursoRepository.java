package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}