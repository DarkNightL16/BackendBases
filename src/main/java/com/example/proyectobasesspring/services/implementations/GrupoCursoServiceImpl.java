package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.GrupoCurso;
import com.example.proyectobasesspring.repositories.GrupoCursoRepository;
import com.example.proyectobasesspring.services.GrupoCursoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GrupoCursoServiceImpl implements GrupoCursoService {
    private final GrupoCursoRepository grupoCursoRepository;

    @Override
    public GrupoCurso guardar(GrupoCurso grupoCurso) {
        return grupoCursoRepository.save(grupoCurso);
    }

    @Override
    public List<GrupoCurso> buscarTodos() {
        return grupoCursoRepository.findAll();
    }

    @Override
    public void eliminarPorId(GrupoCurso grupoCurso) {
        grupoCursoRepository.delete(grupoCurso);
    }

    @Override
    public void actualizar(GrupoCurso grupoCurso) {
        grupoCursoRepository.save(grupoCurso);
    }
}
