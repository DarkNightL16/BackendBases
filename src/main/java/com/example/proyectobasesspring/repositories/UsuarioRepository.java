package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}