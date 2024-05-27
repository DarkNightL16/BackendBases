package com.example.proyectobasesspring.repositories;

import com.example.proyectobasesspring.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long> {
    @Query("SELECT e FROM Examen e WHERE e.gruposIdGrupo.id = ?1")
    List<Examen> buscarExamenPorGrupo(Long idGrupo);

    @Query("SELECT e.nombre, e.descripcion, e.porcentajeCurso, ep.duracion, ep.calificacion FROM Examen e JOIN ExamenPresentado ep ON e.id = ep.examenesIdExamen.id WHERE ep.estudiantesIdUsuario.usuariosIdUsuario = ?1 AND ep.duracion != 0")
    List<Object[]> buscarExamenPorEstudiante(String idEstudiante);

    @Query("SELECT e FROM Examen e WHERE e.profesoresUsuariosIdUsuario.usuariosIdUsuario = ?1")
    List<Examen> buscarExamenPorProfesor(String idProfesor);
}