package com.example.proyectobasesspring.services;

import com.example.proyectobasesspring.model.TipoUsuario;

import java.util.List;
import java.util.Optional;

public interface TipoUsuarioService {
    List<TipoUsuario> listarTiposUsuarios();
    TipoUsuario guardar(TipoUsuario tipoUsuario);
    Optional<TipoUsuario> buscarPorId(Long id);
    public void eliminar(Long id);

}
