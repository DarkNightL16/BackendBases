package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.RespuestaEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestasEstudianteRepository extends JpaRepository<RespuestaEstudiante, Long> {
}