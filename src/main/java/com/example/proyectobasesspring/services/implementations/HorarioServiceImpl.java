package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Horario;
import com.example.proyectobasesspring.repositories.HorarioRepository;
import com.example.proyectobasesspring.services.HorarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HorarioServiceImpl implements HorarioService {
    private HorarioRepository horarioRepository;

    @Override
    public List<Horario> listarHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public Horario guardar(Horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public Optional<Horario> buscarPorId(Long id) {
        return horarioRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        horarioRepository.deleteById(id);
    }
}
