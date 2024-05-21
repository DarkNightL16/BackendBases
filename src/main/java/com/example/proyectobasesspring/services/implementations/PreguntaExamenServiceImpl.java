package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.PreguntaExamen;
import com.example.proyectobasesspring.repositories.PreguntaExamenRepository;
import com.example.proyectobasesspring.services.PreguntaExamenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PreguntaExamenServiceImpl implements PreguntaExamenService {
    private final PreguntaExamenRepository preguntaExamenRepository;

    @Override
    public List<PreguntaExamen> buscarTodos() {
        return preguntaExamenRepository.findAll();
    }

    @Override
    public PreguntaExamen guardar(PreguntaExamen preguntaExamen) {
        return preguntaExamenRepository.save(preguntaExamen);
    }

    @Override
    public Optional<PreguntaExamen> buscarPorId(Long id) {
        return preguntaExamenRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        preguntaExamenRepository.deleteById(id);
    }
}
