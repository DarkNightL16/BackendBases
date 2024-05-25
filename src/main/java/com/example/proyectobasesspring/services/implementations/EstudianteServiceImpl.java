package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Estudiante;
import com.example.proyectobasesspring.repositories.EstudianteRepository;
import com.example.proyectobasesspring.services.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Optional<Estudiante> buscarPorId(String id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public void eliminarPorId(String id) { estudianteRepository.deleteById(id);}
}
