package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.PreguntaEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaEstudianteRepository extends JpaRepository<PreguntaEstudiante, Long> {
}