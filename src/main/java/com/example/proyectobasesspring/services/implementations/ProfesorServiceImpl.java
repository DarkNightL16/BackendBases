package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Profesor;
import com.example.proyectobasesspring.repositories.ProfesorRepository;
import com.example.proyectobasesspring.services.ProfesorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {
    private ProfesorRepository profesorRepository;


    @Override
    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor guardar(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Optional<Profesor> buscarPorId(String id) {
        return profesorRepository.findById(id);
    }

    @Override
    public void eliminarPorId(String id) { profesorRepository.deleteById(id); }
}
