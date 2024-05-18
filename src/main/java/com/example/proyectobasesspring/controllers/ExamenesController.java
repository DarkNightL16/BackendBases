package com.example.proyectobasesspring.controllers;

import com.example.proyectobasesspring.model.Examen;
import com.example.proyectobasesspring.model.Pregunta;
import com.example.proyectobasesspring.model.TiposPregunta;
import com.example.proyectobasesspring.services.implementations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/examenes")
@RequiredArgsConstructor
public class ExamenesController {
    private final ExamenServiceImpl examenService;
    private final ContenidoServiceImpl contenidoService;
    private final ProfesorServiceImpl profesorService;
    private final GrupoServiceImpl grupoService;
    private final TipoPreguntaServiceImpl tipoPreguntaService;
    private final PreguntaServiceImpl preguntaService;

    @PostMapping
    public ResponseEntity<?> registrarExamen(@RequestBody Map<String, Object> cursoData) {
        Examen examen = new Examen();
        examen.setNombre((String) cursoData.get("nombre"));
        examen.setDescripcion((String) cursoData.get("descripcion"));
        Long cantidadPreguntas = Long.parseLong((String)cursoData.get("cantidadPreguntas"));
        examen.setCantidadPreguntasTotales(cantidadPreguntas);
        Long cantidadPreguntasEstudiante = Long.parseLong((String)cursoData.get("cantidadPreguntasEstudiante"));
        examen.setCantidadPreguntasEstudiante(cantidadPreguntasEstudiante);
        Long duracion = Long.parseLong((String)cursoData.get("duracion"));
        examen.setDuracion(duracion);
        examen.setTipoExamen((String) cursoData.get("tipoExamen"));
        Long porcentajeCurso = Long.parseLong((String)cursoData.get("porcentajeCurso"));
        examen.setPorcentajeCurso(porcentajeCurso);
        Long umbralAprobado = Long.parseLong((String)cursoData.get("umbralAprobado"));
        examen.setUmbralAprobado(umbralAprobado);
        examen.setEstadoPublicacion((String) cursoData.get("estadoPublicacion"));

        Long id_contenido = Long.parseLong((String)cursoData.get("id_contenido"));
        examen.setIdContenido(contenidoService.buscarPorId(id_contenido).get());
        String id_profesor = (String)cursoData.get("id_profesor");
        examen.setProfesoresUsuariosIdUsuario(profesorService.buscarPorId(id_profesor).get());
        Long id_grupo = Long.parseLong((String)cursoData.get("id_grupo"));
        examen.setGruposIdGrupo(grupoService.buscarPorId(id_grupo).get());

        try {
            return ResponseEntity.ok().body(examenService.guardar(examen));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    @RequestMapping("/tiposPregunta")
    public ResponseEntity<?> registrarTipoPregunta(@RequestBody Map<String, Object> tipoPreguntaData) {
        TiposPregunta tipoPregunta = new TiposPregunta();
        tipoPregunta.setTipo((String) tipoPreguntaData.get("tipo"));

        try {
            return ResponseEntity.ok().body(tipoPreguntaService.guardar(tipoPregunta));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    @RequestMapping("/preguntas")
    public ResponseEntity<?> registrarPreguntas(@RequestBody Map<String, Object> preguntaData) {
        Pregunta pregunta = new Pregunta();
        pregunta.setTextoPregunta((String) preguntaData.get("textoPregunta"));
        Long privacidad = Long.parseLong((String)preguntaData.get("privacidad"));
        pregunta.setPrivacidad(privacidad);
        Long id_contenido = Long.parseLong((String)preguntaData.get("id_contenido"));
        pregunta.setIdContenido(contenidoService.buscarPorId(id_contenido).get());
        Long id_tipo_pregunta = Long.parseLong((String)preguntaData.get("id_tipo_pregunta"));
        pregunta.setIdTipoPregunta(tipoPreguntaService.buscarPorId(id_tipo_pregunta).get());
        String id_profesor = (String)preguntaData.get("id_profesor");
        pregunta.setIdProfesor(profesorService.buscarPorId(id_profesor).get());
        String id_pregunta_compuesta_s = (String)preguntaData.get("id_pregunta_compuesta");
        if (id_pregunta_compuesta_s.isEmpty()) {
            pregunta.setIdPreguntaCompuesta(null);
        } else {
            Long id_pregunta_compuesta = Long.parseLong(id_pregunta_compuesta_s);
            pregunta.setIdPreguntaCompuesta(preguntaService.buscarPorId(id_pregunta_compuesta).get());
        }

        try {
            return ResponseEntity.ok().body(preguntaService.guardar(pregunta));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
