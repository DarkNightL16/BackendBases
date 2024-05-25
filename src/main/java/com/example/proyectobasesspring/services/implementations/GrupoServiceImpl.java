package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Grupo;
import com.example.proyectobasesspring.repositories.GrupoRepository;
import com.example.proyectobasesspring.services.GrupoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GrupoServiceImpl implements GrupoService {
    private GrupoRepository grupoRepository;

    @Override
    public List<Grupo> listarGrupos() {
        return grupoRepository.findAll();
    }

    @Override
    public Grupo guardar(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Override
    public Optional<Grupo> buscarPorId(Long id) {
        return grupoRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        grupoRepository.deleteById(id);
    }

    @Override
    public List<Grupo> listarGruposPorProfesor(String id_profesor) {
        return grupoRepository.listarGruposPorProfesor(id_profesor);
    }
}
