package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long> {
}