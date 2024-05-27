package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Contenido;

import java.util.List;
import java.util.Optional;

public interface ContenidoService {
    Contenido guardar(Contenido contenido);
    Optional<Contenido> buscarPorId(Long id);
    List<Contenido> buscarTodos();
    void eliminarPorId(Long id);
    List<Contenido> buscarContenidoPorCurso(Long id_curso);
}
