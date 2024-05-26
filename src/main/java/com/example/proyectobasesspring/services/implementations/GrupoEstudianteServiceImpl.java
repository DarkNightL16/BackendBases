package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.GrupoEstudiante;
import com.example.proyectobasesspring.repositories.GrupoEstudianteRepository;
import com.example.proyectobasesspring.services.GrupoEstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GrupoEstudianteServiceImpl implements GrupoEstudianteService {
    private final GrupoEstudianteRepository grupoEstudianteRepository;

    @Override
    public GrupoEstudiante guardar(GrupoEstudiante grupoEstudiante) {
        return grupoEstudianteRepository.save(grupoEstudiante);
    }

    @Override
    public List<GrupoEstudiante> buscarTodos() {
        return grupoEstudianteRepository.findAll();
    }

    @Override
    public void eliminarPorId(GrupoEstudiante grupoEstudiante) {
        grupoEstudianteRepository.delete(grupoEstudiante);
    }

    @Override
    public void actualizar(GrupoEstudiante grupoEstudiante) {
        grupoEstudianteRepository.save(grupoEstudiante);
    }

    @Override
    public List<GrupoEstudiante> listarGruposPorEstudiante(String id_estudiante) {
        return grupoEstudianteRepository.listarGruposPorEstudiante(id_estudiante);
    }
}
