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
    public List<Grupo> listarGrupos() {return grupoRepository.findAll();}

    @Override
    public Grupo guardar(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Override
    public Optional<Grupo> buscarPorId(Long id) {
        return grupoRepository.findById(id);
    }
}