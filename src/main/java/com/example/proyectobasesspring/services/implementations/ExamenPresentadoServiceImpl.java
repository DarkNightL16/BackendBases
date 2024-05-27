package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.ExamenPresentado;
import com.example.proyectobasesspring.repositories.ExamenPresentadoRepository;
import com.example.proyectobasesspring.services.ExamenPresentadoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExamenPresentadoServiceImpl implements ExamenPresentadoService {
    private final ExamenPresentadoRepository examenPresentadoRepository;

    @Override
    public ExamenPresentado guardar(ExamenPresentado examenPresentado) {
        return examenPresentadoRepository.save(examenPresentado);
    }

    @Override
    public Optional<ExamenPresentado> buscarPorId(Long id) {
        return examenPresentadoRepository.findById(id);
    }

    @Override
    public List<ExamenPresentado> buscarTodos() {
        return examenPresentadoRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        examenPresentadoRepository.deleteById(id);
    }

    @Override
    public ExamenPresentado actualizar(ExamenPresentado examenPresentado) {
        return examenPresentadoRepository.save(examenPresentado);
    }
}
