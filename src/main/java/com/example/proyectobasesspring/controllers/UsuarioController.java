package com.example.proyectobasesspring.controllers;

import com.example.proyectobasesspring.model.*;
import com.example.proyectobasesspring.services.implementations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioServiceImpl usuarioService;
    private final TipoUsuarioServiceImpl tipoUsuarioService;
    private final GrupoServiceImpl grupoService;
    private final EstudianteServiceImpl estudianteService;
    private final ProfesorServiceImpl profesorService;
    private final GrupoEstudianteServiceImpl grupoEstudianteService;

    @PostMapping
    public ResponseEntity<?> registrarUsuario(@RequestBody Map<String, Object> userData) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario((String) userData.get("cedula"));
        usuario.setCorreo((String) userData.get("correo"));
        usuario.setContrasena((String) userData.get("contrasena"));
        Long idTipoUsuario = Long.parseLong((String) userData.get("idTipoUsuario"));
        usuario.setIdTipoUsuario(tipoUsuarioService.buscarPorId(idTipoUsuario).get());
        try{
            Usuario usuarioGuardado = usuarioService.guardar(usuario);
            if(usuarioGuardado.getIdTipoUsuario().getId() == 1){
                Estudiante estudiante = new Estudiante();
                estudiante.setUsuarios(usuarioGuardado);
                estudiante.setNombre((String) userData.get("nombre"));
                estudiante.setApellido((String) userData.get("apellido"));
                Long idGrupo = Long.parseLong((String) userData.get("idGrupo"));
                try{
                    estudianteService.guardar(estudiante);
                    return ResponseEntity.ok().body(usuarioGuardado);
                }catch (Exception e){
                    return ResponseEntity.badRequest().body(e.getMessage());
                }
            }else {
                Profesor profesor = new Profesor();
                profesor.setUsuarios(usuarioGuardado);
                profesor.setNombre((String) userData.get("nombre"));
                profesor.setApellido((String) userData.get("apellido"));
                try {
                    profesorService.guardar(profesor);
                    return ResponseEntity.ok().body(usuarioGuardado);
                } catch (Exception e) {
                    return ResponseEntity.badRequest().body(e.getMessage());
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el usuario");
        }
    }

    @GetMapping("/listarUsuarios")
    public ResponseEntity<?> listarUsuarios() {
        try {
            return ResponseEntity.ok().body(usuarioService.listarUsuarios());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping({"/eliminarUsuario"})
    public ResponseEntity<?> eliminarUsuario(@RequestBody Map<String, Object> userData){
        String idUsuario = "idUsuario";
        try{
            usuarioService.eliminarPorId(idUsuario);
            return ResponseEntity.ok().body("Usuario eliminado");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarUsuarioPorId")
    public ResponseEntity<?> buscarUsuarioPorId(@RequestBody Map<String, Object> userData) {
        try {
            return ResponseEntity.ok().body(usuarioService.buscarPorId(userData.get("id_usuario").toString()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarEstudiantes")
    public ResponseEntity<?> listarEstudiantes() {
        try {
            return ResponseEntity.ok().body(estudianteService.listarEstudiantes());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarProfesores")
    public ResponseEntity<?> listarProfesores() {
        try {
            return ResponseEntity.ok().body(profesorService.listarProfesores());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarEstudiantePorId")
    public ResponseEntity<?> buscarEstudiantePorId(@RequestParam String id_estudiante) {
        try {
            return ResponseEntity.ok().body(estudianteService.buscarPorId(id_estudiante));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarProfesorPorId")
    public ResponseEntity<?> buscarProfesorPorId(@RequestParam String id_profesor) {
        try {
            return ResponseEntity.ok().body(profesorService.buscarPorId(id_profesor));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping({"/grupos"})
    public ResponseEntity<?> crearGrupo(@RequestBody Map<String, Object> userData) {
        Grupo grupo = new Grupo();
        grupo.setId((Long) userData.get("id"));
        grupo.setNombreGrupo((String) userData.get("nombreGrupo"));
        try{
            grupo.setProfesoresUsuariosIdUsuario(profesorService.buscarPorId((String) userData.get("idProfesor")).get());
            Grupo grupoCreado = grupoService.guardar(grupo);
            return ResponseEntity.ok().body(grupoCreado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarGruposPorProfesor/{id_profesor}")
    public ResponseEntity<?> listarGruposPorProfesor(@PathVariable  String id_profesor) {
        try {
            return ResponseEntity.ok().body(grupoService.listarGruposPorProfesor(id_profesor));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarGruposPorEstudiante/{id_estudiante}")
    public ResponseEntity<?> buscarGrupoEstudiantePorId(@PathVariable String id_estudiante) {
        try {
            return ResponseEntity.ok().body(grupoEstudianteService.listarGruposPorEstudiante(id_estudiante));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarGrupos")
    public ResponseEntity<?> listarGrupos() {
        try {
            return ResponseEntity.ok().body(grupoService.listarGrupos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarGrupoPorId")
    public ResponseEntity<?> buscarGrupoPorId(@RequestBody Map<String, Object> grupoData) {
        Long id_grupo = Long.parseLong((String) grupoData.get("id_grupo"));
        try {
            return ResponseEntity.ok().body(grupoService.buscarPorId(id_grupo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("agregarGrupoEstudiante")
    public ResponseEntity<?> agregarGrupoEstudiante(@RequestBody Map<String, Object> grupoEstudianteData) {
        try {
            GrupoEstudiante grupoEstudiante = new GrupoEstudiante();
            GrupoEstudianteId grupoEstudianteId = new GrupoEstudianteId();

            Long id_grupo = Long.parseLong((String) grupoEstudianteData.get("id_grupo"));
            String id_estudiante = (String) grupoEstudianteData.get("id_estudiante");

            grupoEstudianteId.setIdGrupo(id_grupo);
            grupoEstudianteId.setIdEstudiante(id_estudiante);

            grupoEstudiante.setId(grupoEstudianteId);

            grupoEstudiante.setIdEstudiante(estudianteService.buscarPorId(id_estudiante).get());
            grupoEstudiante.setIdGrupo(grupoService.buscarPorId(id_grupo).get());

            return ResponseEntity.ok().body(grupoEstudianteService.guardar(grupoEstudiante));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarGrupoEstudiantes")
    public ResponseEntity<?> listarGrupoEstudiantes() {
        try {
            return ResponseEntity.ok().body(grupoEstudianteService.buscarTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
