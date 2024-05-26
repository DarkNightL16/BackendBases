package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Unidad;
import com.example.proyectobasesspring.repositories.UnidadRepository;
import com.example.proyectobasesspring.services.UnidadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UnidadServiceImpl implements UnidadService {
    private final UnidadRepository unidadRepository;

    @Override
    public Unidad guardar(Unidad unidad) {
        return unidadRepository.save(unidad);
    }

    @Override
    public void eliminar(Long id_unidad) {
        unidadRepository.deleteById(id_unidad);
    }

    @Override
    public List<Unidad> buscarTodos() {
        return unidadRepository.findAll();
    }

    @Override
    public Optional<Unidad> buscarPorId(Long id) {
        return unidadRepository.findById(id);
    }
}
