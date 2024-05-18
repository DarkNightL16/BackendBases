package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Examen;

import java.util.List;
import java.util.Optional;

public interface ExamenService {
    List<Examen> buscarTodos();
    Examen guardar(Examen examen);
    Optional<Examen> buscarPorId(Long id);
    void eliminar(Long id);
}
