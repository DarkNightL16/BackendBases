package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
    @Query("SELECT co FROM Contenido co " +
            "JOIN Unidad u ON co.unidadesIdUnidad.id = u.id " +
            "JOIN PlanEstudio p ON u.planEstudioIdPlan.id = p.id " +
            "JOIN Curso c ON p.cursosIdCurso.id = c.id " +
            "WHERE c.id = ?1")
    List<Contenido> buscarContenidoPorCurso(Long id_curso);
}