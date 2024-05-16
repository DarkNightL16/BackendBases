package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {
}