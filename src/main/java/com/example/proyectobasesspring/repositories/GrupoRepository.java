package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    @Query("SELECT g FROM Grupo g WHERE g.profesoresUsuariosIdUsuario.usuariosIdUsuario = ?1")
    List<Grupo> listarGruposPorProfesor(String id_profesor);
}