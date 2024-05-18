package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Unidad;

import java.util.List;
import java.util.Optional;

public interface UnidadService {
    public Unidad guardar(Unidad unidad);
    public void eliminar(Unidad unidad);
    public List<Unidad> buscarTodos();
    public Optional<Unidad> buscarPorId(Long id);
}
