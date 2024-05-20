package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.ExamenPresentado;

import java.util.List;
import java.util.Optional;

public interface ExamenPresentadoService {
    ExamenPresentado guardar(ExamenPresentado examenPresentado);
    Optional<ExamenPresentado> buscarPorId(Long id);
    List<ExamenPresentado> buscarTodos();
    void eliminarPorId(Long id);
    ExamenPresentado actualizar(ExamenPresentado examenPresentado);
}
