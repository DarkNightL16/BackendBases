package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.TipoUsuario;
import com.example.proyectobasesspring.repositories.TipoUsuarioRepository;
import com.example.proyectobasesspring.services.TipoUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoUsuarioServiceImpl implements TipoUsuarioService {
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public List<TipoUsuario> listarTiposUsuarios() {
        return tipoUsuarioRepository.findAll();
    }

    @Override
    public TipoUsuario guardar(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    public Optional<TipoUsuario> buscarPorId(Long id) {
        return tipoUsuarioRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) { tipoUsuarioRepository.deleteById(id);}
}
