package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Contenido;
import com.example.proyectobasesspring.repositories.ContenidoRepository;
import com.example.proyectobasesspring.services.ContenidoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContenidoServiceImpl implements ContenidoService {
    private final ContenidoRepository contenidoRepository;

    @Override
    public Contenido guardar(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    @Override
    public Optional<Contenido> buscarPorId(Long id) {
        return contenidoRepository.findById(id);
    }

    //aaa
    @Override
    public List<Contenido> buscarTodos() {
        return contenidoRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        contenidoRepository.deleteById(id);
    }

    @Override
    public List<Contenido> buscarContenidoPorCurso(Long id_curso) {
        return contenidoRepository.buscarContenidoPorCurso(id_curso);
    }

}
