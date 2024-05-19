package com.example.proyectobasesspring.services.implementations;

import com.example.proyectobasesspring.model.Usuario;
import com.example.proyectobasesspring.repositories.UsuarioRepository;
import com.example.proyectobasesspring.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void eliminarPorId(String id) { usuarioRepository.deleteById(id);}
}
