package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Unidad;

import java.util.List;
import java.util.Optional;

public interface UnidadService {
    Unidad guardar(Unidad unidad);
    void eliminar(Long id_unidad);
    List<Unidad> buscarTodos();
    Optional<Unidad> buscarPorId(Long id);
}
