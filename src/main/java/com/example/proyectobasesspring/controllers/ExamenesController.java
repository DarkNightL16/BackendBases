package com.example.proyectobasesspring.controllers;

import com.example.proyectobasesspring.model.*;
import com.example.proyectobasesspring.services.implementations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private final HorarioServiceImpl horarioService;
    private final EstudianteServiceImpl estudianteService;
    private final ExamenPresentadoServiceImpl examenPresentadoService;
    private final OpcionServiceImpl opcionService;

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

    @PostMapping("/tiposPregunta")
    public ResponseEntity<?> registrarTipoPregunta(@RequestBody Map<String, Object> tipoPreguntaData) {
        TiposPregunta tipoPregunta = new TiposPregunta();
        tipoPregunta.setTipo((String) tipoPreguntaData.get("tipo"));

        try {
            return ResponseEntity.ok().body(tipoPreguntaService.guardar(tipoPregunta));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/preguntas")
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


    @GetMapping("/listarExamenes")
    public ResponseEntity<?> listarExamenes() {
        try {
            return ResponseEntity.ok().body(examenService.buscarTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/horarios")
    public ResponseEntity<?> registrarHorario(@RequestBody Map<String, Object> horarioData) {
        Horario horario = new Horario();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String fecha = (String) horarioData.get("dia");
        LocalDate dia = LocalDate.parse(fecha, formatter);
        horario.setDia(dia);

        Timestamp horaInicio = Timestamp.valueOf((String) horarioData.get("horaInicio"));
        horario.setHoraInicio(horaInicio);

        Timestamp horaFin = Timestamp.valueOf((String) horarioData.get("horaFin"));
        horario.setHoraFin(horaFin);

        Long id_examen = Long.parseLong((String)horarioData.get("id_examen"));
        horario.setExamenesIdExamen(examenService.buscarPorId(id_examen).get());

        try {
            return ResponseEntity.ok().body(horarioService.guardar(horario));
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping({"/elminarExamen"})
    public ResponseEntity<?> eliminarExamen(@RequestBody Map<Long, Object> userData){
        Long idExamen = Long.parseLong((String) userData.get("idExamen"));
        try {
            examenService.eliminar(idExamen);
            return ResponseEntity.ok().body("Examen eliminado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarHorarios")
    public ResponseEntity<?> listarHorarios() {
        return ResponseEntity.ok().body(horarioService.listarHorarios());
    }

    @DeleteMapping("/eliminarHorarios")
    public ResponseEntity<?> eliminarHorarios(@RequestBody Map<String, Object> horarioData) {
        Long id_examen = Long.parseLong((String)horarioData.get("id_examen"));
        try{
            horarioService.eliminarPorId(id_examen);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Horario eliminado");
    }

    @PostMapping("/examenPresentado")
    public ResponseEntity<?> registrarExamenPresentado(@RequestBody Map<String, Object> examenPresentadoData) {
        ExamenPresentado examenPresentado = new ExamenPresentado();

        Long id_examen = Long.parseLong((String)examenPresentadoData.get("id_examen"));
        examenPresentado.setExamenesIdExamen(examenService.buscarPorId(id_examen).get());

        String id_estudiante = (String)examenPresentadoData.get("id_estudiante");
        examenPresentado.setEstudiantesIdUsuario(estudianteService.buscarPorId(id_estudiante).get());


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String fecha = (String) examenPresentadoData.get("fechaPresentacion");
        LocalDate fechaPresentacion = LocalDate.parse(fecha, formatter);
        examenPresentado.setFechaPresentacion(fechaPresentacion);

        Long duracion = Long.parseLong((String)examenPresentadoData.get("duracion"));
        examenPresentado.setDuracion(duracion);

        Long calificacion = Long.parseLong((String)examenPresentadoData.get("calificacion"));
        examenPresentado.setCalificacion(calificacion);

        System.out.println(examenPresentado);

        try {
            return ResponseEntity.ok().body(examenPresentadoService.guardar(examenPresentado));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarExamenPresentado")
    public ResponseEntity<?> listarExamenPresentado() {
        return ResponseEntity.ok().body(examenPresentadoService.buscarTodos());
    }

    @DeleteMapping("/eliminarExamenPresentado")
    public ResponseEntity<?> eliminarExamenPresentado(@RequestBody Map<String, Object> examenPresentadoData) {
        Long id_presentacion = Long.parseLong((String)examenPresentadoData.get("id_presentacion"));
        try{
            examenPresentadoService.eliminarPorId(id_presentacion);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Examen Presentado eliminado");
    }

    @PostMapping("/opciones")
    public ResponseEntity<?> registrarOpciones(@RequestBody Map<String, Object> opcionData) {
        Opcion opcion = new Opcion();
        opcion.setTexto((String) opcionData.get("texto"));
        opcion.setRespuesta((String) opcionData.get("respuesta"));

        Long id_pregunta = Long.parseLong((String)opcionData.get("id_pregunta"));
        opcion.setPreguntasIdPregunta(preguntaService.buscarPorId(id_pregunta).get());

        String id_opcion = (String)opcionData.get("id_opcion");
        if (id_opcion.isEmpty()) {
            opcion.setOpcionesIdOpcion(null);
        } else {
            Long id_opcion_l = Long.parseLong(id_opcion);
            opcion.setOpcionesIdOpcion(opcionService.buscarPorId(id_opcion_l).get());
        }

        try {
            return ResponseEntity.ok().body(opcionService.guardar(opcion));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarOpciones")
    public ResponseEntity<?> listarOpciones() {
        return ResponseEntity.ok().body(opcionService.buscarTodos());
    }

    @DeleteMapping("/eliminarOpciones")
    public ResponseEntity<?> eliminarOpciones(@RequestBody Map<String, Object> opcionData) {
        Long id_opcion = Long.parseLong((String)opcionData.get("id_presentacion"));
        try{
            opcionService.eliminarPorId(id_opcion);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Opción eliminada");
    }

}
