package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Curso;
import com.example.proyectobasesspring.repositories.CursoRepository;
import com.example.proyectobasesspring.services.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CursoServiceImpl implements CursoService {
    private CursoRepository cursoRepository;

    @Override
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Optional<Curso> buscarPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public List<Curso> buscarTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public Curso actualizar(Curso curso) {
        return cursoRepository.save(curso);
    }

}
