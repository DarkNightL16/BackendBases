package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.GrupoCurso;

import java.util.List;

public interface GrupoCursoService {
    public GrupoCurso guardar(GrupoCurso grupoCurso);
    public List<GrupoCurso> buscarTodos();
    public void eliminarPorId(GrupoCurso grupoCurso);
    public void actualizar(GrupoCurso grupoCurso);
}
