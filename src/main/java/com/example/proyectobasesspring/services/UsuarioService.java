package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listarUsuarios();
    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorId(String id);
    public void eliminarPorId(String id);
}
