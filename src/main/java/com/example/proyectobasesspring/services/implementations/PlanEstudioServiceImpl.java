package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.PlanEstudio;
import com.example.proyectobasesspring.repositories.PlanEstudioRepository;
import com.example.proyectobasesspring.services.PlanEstudioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlanEstudioServiceImpl implements PlanEstudioService {
    private final PlanEstudioRepository planEstudioRepository;

    @Override
    public PlanEstudio guardar(PlanEstudio planEstudio) {
        return planEstudioRepository.save(planEstudio);
    }

    @Override
    public Optional<PlanEstudio> buscarPorId(Long id) {
        return planEstudioRepository.findById(id);
    }

    @Override
    public List<PlanEstudio> buscarTodos() {
        return planEstudioRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        planEstudioRepository.deleteById(id);
    }
}
