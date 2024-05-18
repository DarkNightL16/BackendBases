package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Pregunta;
import com.example.proyectobasesspring.repositories.PreguntaRepository;
import com.example.proyectobasesspring.services.PreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PreguntaServiceImpl implements PreguntaService {
    private final PreguntaRepository preguntaRepository;

    @Override
    public Pregunta guardar(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Optional<Pregunta> buscarPorId(Long id) {
        return preguntaRepository.findById(id);
    }

    @Override
    public List<Pregunta> buscarTodos() {
        return preguntaRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        preguntaRepository.deleteById(id);
    }
}
