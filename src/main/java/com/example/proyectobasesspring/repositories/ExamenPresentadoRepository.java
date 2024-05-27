package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.ExamenPresentado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenPresentadoRepository extends JpaRepository<ExamenPresentado, Long> {
}