package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.RespuestaEstudiante;
import com.example.proyectobasesspring.repositories.RespuestasEstudianteRepository;
import com.example.proyectobasesspring.services.RespuestaEstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RespuestaEstudianteServiceImpl implements RespuestaEstudianteService {
    private final RespuestasEstudianteRepository respuestasEstudianteRepository;

    @Override
    public List<RespuestaEstudiante> buscarTodos() {
        return respuestasEstudianteRepository.findAll();
    }

    @Override
    public RespuestaEstudiante guardar(RespuestaEstudiante respuestaEstudiante) {
        return respuestasEstudianteRepository.save(respuestaEstudiante);
    }

    @Override
    public Optional<RespuestaEstudiante> buscarPorId(Long id) {
        return respuestasEstudianteRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        respuestasEstudianteRepository.deleteById(id);
    }
}
