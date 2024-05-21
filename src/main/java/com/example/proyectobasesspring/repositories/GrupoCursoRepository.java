package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.GrupoCurso;
import com.example.proyectobasesspring.model.GrupoCursoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoCursoRepository extends JpaRepository<GrupoCurso, GrupoCursoId> {
}