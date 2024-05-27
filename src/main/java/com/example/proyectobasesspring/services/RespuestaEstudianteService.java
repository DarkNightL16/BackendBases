package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.RespuestaEstudiante;

import java.util.List;
import java.util.Optional;

public interface RespuestaEstudianteService {
    List<RespuestaEstudiante> buscarTodos();
    RespuestaEstudiante guardar(RespuestaEstudiante respuestaEstudiante);
    Optional<RespuestaEstudiante> buscarPorId(Long id);
    void eliminarPorId(Long id);
}
