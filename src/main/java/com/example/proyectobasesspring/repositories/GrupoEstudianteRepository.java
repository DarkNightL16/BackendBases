package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.GrupoEstudiante;
import com.example.proyectobasesspring.model.GrupoEstudianteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoEstudianteRepository extends JpaRepository<GrupoEstudiante, GrupoEstudianteId> {
    @Query("SELECT ge FROM GrupoEstudiante ge WHERE ge.idEstudiante.usuariosIdUsuario = ?1")
    List<GrupoEstudiante> listarGruposPorEstudiante(String id_estudiante);
}