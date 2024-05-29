package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Usuario;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query("SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario AND u.contrasena = :contrasena")
    Optional<Usuario> findByIdAndContrasena(String idUsuario, String contrasena);
}
