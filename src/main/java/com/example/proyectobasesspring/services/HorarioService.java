package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Horario;

import java.util.List;
import java.util.Optional;

public interface HorarioService {
    List<Horario> listarHorarios();
    Horario guardar(Horario horario);
    Optional<Horario> buscarPorId(Long id);
    void eliminarPorId(Long id);


}
