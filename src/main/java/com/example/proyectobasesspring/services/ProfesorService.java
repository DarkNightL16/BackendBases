package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    List<Profesor> listarUsuarios();
    Profesor guardar(Profesor profesor);
    Optional<Profesor> buscarPorId(String id);
}
