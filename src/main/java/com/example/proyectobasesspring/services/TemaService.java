package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Tema;

import java.util.List;
import java.util.Optional;

public interface TemaService {
    public Tema guardar(Tema tema);
    public void eliminar(Tema tema);
    public List<Tema> buscarTodos();
    public Optional<Tema> buscarPorId(Long id);
}
