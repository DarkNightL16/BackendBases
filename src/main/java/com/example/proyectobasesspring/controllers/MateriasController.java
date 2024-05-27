package com.example.proyectobasesspring.controllers;

import com.example.proyectobasesspring.model.*;
import com.example.proyectobasesspring.services.implementations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/materias")
@RequiredArgsConstructor
public class MateriasController {
    private final CursoServiceImpl cursoService;
    private final PlanEstudioServiceImpl planEstudioService;
    private final UnidadServiceImpl unidadService;
    private final ContenidoServiceImpl contenidoService;
    private final GrupoCursoServiceImpl grupoCursoService;
    private final GrupoServiceImpl grupoService;

    @PostMapping
    public ResponseEntity<?> registrarCurso(@RequestBody Map<String, Object> cursoData) {

        Curso curso = new Curso();
        curso.setNombre((String) cursoData.get("nombre"));
        curso.setDescripcion((String) cursoData.get("descripcion"));
        String fecha = (String) cursoData.get("fechaInicio");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaInicio = LocalDate.parse(fecha, formatter);
        curso.setFechaInicio(fechaInicio);
        Long duracion = Long.parseLong((String)cursoData.get("duracion"));
        curso.setDuracion(duracion);

        try {
            return ResponseEntity.ok().body(cursoService.guardar(curso));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("listarCursos")
    public ResponseEntity<?> listarCursos() {
        try {
            return ResponseEntity.ok().body(cursoService.buscarTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarCursoPorId")
    public ResponseEntity<?> buscarCursoPorId(@RequestBody Map<String, Object> cursoData) {
        try {
            Long id_curso = Long.parseLong((String)cursoData.get("id_curso"));
            return ResponseEntity.ok().body(cursoService.buscarPorId(id_curso));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarCurso")
    public ResponseEntity<?> eliminarCurso(@RequestBody Map<String, Object> cursoData) {
        try {
            Long id_curso = Long.parseLong((String)cursoData.get("id_curso"));
            cursoService.eliminarPorId(id_curso);
            return ResponseEntity.ok().body("Curso eliminado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/planesEstudio")
    public ResponseEntity<?> registrarPlanEstudio(@RequestBody Map<String, Object> planEstudioData) {
        PlanEstudio planEstudio = new PlanEstudio();
        planEstudio.setNombre((String) planEstudioData.get("nombre"));
        planEstudio.setDescripcion((String) planEstudioData.get("descripcion"));
        Long id_curso = Long.parseLong((String)planEstudioData.get("id_curso"));
        planEstudio.setCursosIdCurso(cursoService.buscarPorId(id_curso).get());

        try {
            return ResponseEntity.ok().body(planEstudioService.guardar(planEstudio));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("listarPlanesEstudio")
    public ResponseEntity<?> listarPlanesEstudio() {
        try {
            return ResponseEntity.ok().body(planEstudioService.buscarTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarPlanEstudioPorId")
    public ResponseEntity<?> buscarPlanEstudioPorId(@RequestBody Map<String, Object> planEstudioData) {
        try {
            Long id_plan_estudio = Long.parseLong((String)planEstudioData.get("id_plan_estudio"));
            return ResponseEntity.ok().body(planEstudioService.buscarPorId(id_plan_estudio));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarPlanEstudio")
    public ResponseEntity<?> eliminarPlanEstudio(@RequestBody Map<String, Object> planEstudioData) {
        try {
            Long id_plan_estudio = Long.parseLong((String)planEstudioData.get("id_plan_estudio"));
            cursoService.eliminarPorId(id_plan_estudio);
            return ResponseEntity.ok().body("Plan de Estudio eliminado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/unidades")
    public ResponseEntity<?> registrarUnidades(@RequestBody Map<String, Object> unidadesData) {
        Unidad unidad = new Unidad();
        unidad.setNombre((String) unidadesData.get("nombre"));
        unidad.setDescripcion((String) unidadesData.get("descripcion"));
        Long id_plan = Long.parseLong((String)unidadesData.get("id_plan"));
        unidad.setPlanEstudioIdPlan(planEstudioService.buscarPorId(id_plan).get());
        try {
            return ResponseEntity.ok().body(unidadService.guardar(unidad));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("listarUnidades")
    public ResponseEntity<?> listarUnidades() {
        try {
            return ResponseEntity.ok().body(unidadService.buscarTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarUnidadPorId")
    public ResponseEntity<?> buscarUnidadPorId(@RequestBody Map<String, Object> unidadData) {
        try {
            Long id_unidad = Long.parseLong((String)unidadData.get("id_unidad"));
            return ResponseEntity.ok().body(unidadService.buscarPorId(id_unidad));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarUnidad")
    public ResponseEntity<?> eliminarUnidad(@RequestBody Map<String, Object> unidadData) {
        try {
            Long id_unidad = Long.parseLong((String)unidadData.get("id_unidad"));
            unidadService.eliminar(id_unidad);
            return ResponseEntity.ok().body("Unidad eliminada");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/contenidos")
    public ResponseEntity<?> registrarContenido(@RequestBody Map<String, Object> contenidoData) {
        Contenido contenido = new Contenido();
        contenido.setNombre((String) contenidoData.get("nombre"));
        contenido.setDescripcion((String) contenidoData.get("descripcion"));
        Long id_unidad = Long.parseLong((String)contenidoData.get("id_unidad"));
        contenido.setUnidadesIdUnidad(unidadService.buscarPorId(id_unidad).get());

        try {
            return ResponseEntity.ok().body(contenidoService.guardar(contenido));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("listarContenidos")
    public ResponseEntity<?> listarContenidos() {
        try {
            return ResponseEntity.ok().body(contenidoService.buscarTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarContenidoPorId")
    public ResponseEntity<?> buscarContenidoPorId(@RequestBody Map<String, Object> contenidoData) {
        try {
            Long id_contenido = Long.parseLong((String)contenidoData.get("id_contenido"));
            return ResponseEntity.ok().body(contenidoService.buscarPorId(id_contenido));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarContenido")
    public ResponseEntity<?> eliminarContenido(@RequestBody Map<String, Object> contenidoData) {
        try {
            Long id_contenido = Long.parseLong((String)contenidoData.get("id_contenido"));
            contenidoService.eliminarPorId(id_contenido);
            return ResponseEntity.ok().body("Contenido eliminada");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/grupoCurso")
    public ResponseEntity<?> registrarGrupoCurso(@RequestBody Map<String, Object> grupoCursoData) {
        GrupoCurso grupoCurso = new GrupoCurso();
        GrupoCursoId grupoCursoId = new GrupoCursoId();

        Long id_grupo = Long.parseLong((String)grupoCursoData.get("id_grupo"));
        Long id_curso = Long.parseLong((String)grupoCursoData.get("id_curso"));

        grupoCursoId.setGruposIdGrupo(id_grupo);
        grupoCursoId.setCursosIdCurso(id_curso);

        grupoCurso.setId(grupoCursoId);

        try {
            grupoCurso.setGruposIdGrupo(grupoService.buscarPorId(id_grupo).get());
            grupoCurso.setCursosIdCurso(cursoService.buscarPorId(id_curso).get());
            return ResponseEntity.ok().body(grupoCursoService.guardar(grupoCurso));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarContenidoPorCurso")
    public ResponseEntity<?> buscarContenidoPorCurso(@RequestBody Map<String, Object> cursoData) {
        try {
            Long id_curso = Long.parseLong((String)cursoData.get("id_curso"));
            return ResponseEntity.ok().body(contenidoService.buscarContenidoPorCurso(id_curso));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
