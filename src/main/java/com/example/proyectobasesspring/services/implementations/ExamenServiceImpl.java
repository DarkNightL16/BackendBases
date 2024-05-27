package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Examen;
import com.example.proyectobasesspring.repositories.ExamenRepository;
import com.example.proyectobasesspring.services.ExamenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExamenServiceImpl implements ExamenService {
    private final ExamenRepository examenRepository;

    @Override
    public Examen guardar(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Optional<Examen> buscarPorId(Long id) {
        return examenRepository.findById(id);
    }

    @Override
    public List<Examen> buscarTodos() {
        return examenRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        examenRepository.deleteById(id);
    }

    @Override
    public List<Examen> buscarExamenPorGrupo(Long idGrupo) {
        return examenRepository.buscarExamenPorGrupo(idGrupo);
    }

    @Override
    public List<Object[]> buscarExamenPorEstudiante(String idEstudiante) {return examenRepository.buscarExamenPorEstudiante(idEstudiante);}

    @Override
    public List<Examen> buscarExamenPorProfesor(String idProfesor) {
        return examenRepository.buscarExamenPorProfesor(idProfesor);
    }


}
