package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Grupo;
import com.example.proyectobasesspring.services.GrupoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GrupoServiceImpl implements GrupoService {
    private GrupoService grupoService;

    @Override
    public List<Grupo> listarGrupos() {
        return grupoService.listarGrupos();
    }

    @Override
    public Grupo guardar(Grupo grupo) {
        return grupoService.guardar(grupo);
    }

    @Override
    public Optional<Grupo> buscarPorId(Long id) {
        return grupoService.buscarPorId(id);
    }
}
