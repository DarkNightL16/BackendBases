package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    Curso guardar(Curso curso);
    Optional<Curso> buscarPorId(Long id);
    List<Curso> buscarTodos();
    void eliminarPorId(Long id);
    Curso actualizar(Curso curso);
}
