package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Grupo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GrupoService {
    List<Grupo> listarGrupos();
    Grupo guardar(Grupo grupo);
    Optional<Grupo> buscarPorId(Long id);
    void eliminarPorId(Long id);
    List<Grupo> listarGruposPorProfesor(String id_profesor);
}
