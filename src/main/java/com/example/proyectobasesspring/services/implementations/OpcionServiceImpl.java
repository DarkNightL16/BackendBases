package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Opcion;
import com.example.proyectobasesspring.repositories.OpcionRepository;
import com.example.proyectobasesspring.services.OpcionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OpcionServiceImpl implements OpcionService {
    private OpcionRepository opcionRepository;

    @Override
    public Opcion guardar(Opcion opcion) {
        return opcionRepository.save(opcion);
    }

    @Override
    public Optional<Opcion> buscarPorId(Long id) {
        return opcionRepository.findById(id);
    }

    @Override
    public List<Opcion> buscarTodos() {
        return opcionRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        opcionRepository.deleteById(id);
    }

    @Override
    public Opcion actualizar(Opcion opcion) {
        return opcionRepository.save(opcion);
    }
}
