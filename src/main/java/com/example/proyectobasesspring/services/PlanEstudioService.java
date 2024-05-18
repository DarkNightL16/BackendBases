package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.PlanEstudio;

import java.util.List;
import java.util.Optional;

public interface PlanEstudioService {
    public PlanEstudio guardar(PlanEstudio planEstudio);
    public Optional<PlanEstudio> buscarPorId(Long id);
    public List<PlanEstudio> buscarTodos();
    public void eliminarPorId(Long id);
}
