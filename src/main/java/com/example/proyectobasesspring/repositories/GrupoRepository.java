package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
}