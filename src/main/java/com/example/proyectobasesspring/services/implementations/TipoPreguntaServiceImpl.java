package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.TiposPregunta;
import com.example.proyectobasesspring.repositories.TiposPreguntaRepository;
import com.example.proyectobasesspring.services.TipoPreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoPreguntaServiceImpl implements TipoPreguntaService {
    private final TiposPreguntaRepository tipoPreguntaRepository;

    @Override
    public List<TiposPregunta> buscarTodos() {
        return tipoPreguntaRepository.findAll();
    }

    @Override
    public Optional<TiposPregunta> buscarPorId(Long id) {
        return tipoPreguntaRepository.findById(id);
    }

    @Override
    public TiposPregunta guardar(TiposPregunta tipoPregunta) {
        return tipoPreguntaRepository.save(tipoPregunta);
    }

    @Override
    public void eliminar(Long id) {
        tipoPreguntaRepository.deleteById(id);
    }
}
