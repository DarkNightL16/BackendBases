package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.GrupoEstudiante;

import java.util.List;

public interface GrupoEstudianteService {
    GrupoEstudiante guardar(GrupoEstudiante grupoEstudiante);
    List<GrupoEstudiante> buscarTodos();
    void eliminarPorId(GrupoEstudiante grupoEstudiante);
    void actualizar(GrupoEstudiante grupoEstudiante);
    List<GrupoEstudiante> listarGruposPorEstudiante(String id_estudiante);
}
