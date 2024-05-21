package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.PreguntaExamen;

import java.util.List;
import java.util.Optional;

public interface PreguntaExamenService {
    List<PreguntaExamen> buscarTodos();
    PreguntaExamen guardar(PreguntaExamen preguntaExamen);
    Optional<PreguntaExamen> buscarPorId(Long id);
    void eliminarPorId(Long id);
}
