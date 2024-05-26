package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.GrupoCurso;

import java.util.List;

public interface GrupoCursoService {
    GrupoCurso guardar(GrupoCurso grupoCurso);
    List<GrupoCurso> buscarTodos();
    void eliminarPorId(GrupoCurso grupoCurso);
    void actualizar(GrupoCurso grupoCurso);
}
