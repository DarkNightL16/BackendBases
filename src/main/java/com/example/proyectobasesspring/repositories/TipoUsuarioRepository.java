package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
}