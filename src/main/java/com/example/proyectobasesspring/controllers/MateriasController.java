package com.example.proyectobasesspring.controllers;

import com.example.proyectobasesspring.model.Contenido;
import com.example.proyectobasesspring.model.Curso;
import com.example.proyectobasesspring.model.PlanEstudio;
import com.example.proyectobasesspring.model.Unidad;
import com.example.proyectobasesspring.services.implementations.ContenidoServiceImpl;
import com.example.proyectobasesspring.services.implementations.CursoServiceImpl;
import com.example.proyectobasesspring.services.implementations.PlanEstudioServiceImpl;
import com.example.proyectobasesspring.services.implementations.UnidadServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    @RequestMapping("/planesEstudio")
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

    @PostMapping
    @RequestMapping("/unidades")
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

    @PostMapping
    @RequestMapping("/contenidos")
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
}
