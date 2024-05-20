package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Opcion;

import java.util.List;
import java.util.Optional;

public interface OpcionService {
    Opcion guardar(Opcion opcion);
    Optional<Opcion> buscarPorId(Long id);
    List<Opcion> buscarTodos();
    void eliminarPorId(Long id);
    Opcion actualizar(Opcion opcion);
}
