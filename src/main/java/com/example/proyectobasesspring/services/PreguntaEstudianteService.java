package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.PreguntaEstudiante;

import java.util.List;
import java.util.Optional;

public interface PreguntaEstudianteService {
    List<PreguntaEstudiante> buscarTodos();
    PreguntaEstudiante guardar(PreguntaEstudiante preguntaEstudiante);
    Optional<PreguntaEstudiante> buscarPorId(Long id);
    void eliminarPorId(Long id);
}
