package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.TiposPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposPreguntaRepository extends JpaRepository<TiposPregunta, Long> {
}