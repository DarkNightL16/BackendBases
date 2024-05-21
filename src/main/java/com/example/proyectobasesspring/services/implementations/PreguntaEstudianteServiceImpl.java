package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.PreguntaEstudiante;
import com.example.proyectobasesspring.repositories.PreguntaEstudianteRepository;
import com.example.proyectobasesspring.services.PreguntaEstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PreguntaEstudianteServiceImpl implements PreguntaEstudianteService {
    private final PreguntaEstudianteRepository preguntaEstudianteRepository;

    @Override
    public List<PreguntaEstudiante> buscarTodos() {
        return preguntaEstudianteRepository.findAll();
    }

    @Override
    public PreguntaEstudiante guardar(PreguntaEstudiante preguntaEstudiante) {
        return preguntaEstudianteRepository.save(preguntaEstudiante);
    }

    @Override
    public Optional<PreguntaEstudiante> buscarPorId(Long id) {
        return preguntaEstudianteRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        preguntaEstudianteRepository.deleteById(id);
    }
}
