package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.TiposPregunta;

import java.util.List;
import java.util.Optional;

public interface TipoPreguntaService {
    public List<TiposPregunta> buscarTodos();
    public Optional<TiposPregunta> buscarPorId(Long id);
    public TiposPregunta guardar(TiposPregunta tipoPregunta);
    public void eliminar(Long id);
}
