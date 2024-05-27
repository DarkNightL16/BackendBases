package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Pregunta;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {
    public List<Pregunta> buscarTodos();
    public Optional<Pregunta> buscarPorId(Long id);
    public Pregunta guardar(Pregunta Pregunta);
    public void eliminar(Long id);

}
