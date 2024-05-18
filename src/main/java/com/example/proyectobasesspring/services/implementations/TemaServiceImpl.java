package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Tema;
import com.example.proyectobasesspring.repositories.TemaRepository;
import com.example.proyectobasesspring.services.TemaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TemaServiceImpl implements TemaService {
    private final TemaRepository temaRepository;


    @Override
    public Tema guardar(Tema tema) {
        return temaRepository.save(tema);
    }

    @Override
    public void eliminar(Tema tema) {
        temaRepository.delete(tema);
    }

    @Override
    public List<Tema> buscarTodos() {
        return temaRepository.findAll();
    }

    @Override
    public Optional<Tema> buscarPorId(Long id) {
        return temaRepository.findById(id);
    }
}
