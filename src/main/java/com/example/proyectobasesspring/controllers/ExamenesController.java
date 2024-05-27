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
    private final PreguntaExamenServiceImpl preguntaExamenService;
    private final PreguntaEstudianteServiceImpl preguntaEstudianteService;
    private final RespuestaEstudianteServiceImpl respuestaEstudianteService;

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

    @PostMapping("/preguntasExamen")
    public ResponseEntity<?> registrarPreguntasExamen(@RequestBody Map<String, Object> preguntasExamenData) {
        PreguntaExamen preguntaExamen = new PreguntaExamen();

        Long id_examen = Long.parseLong((String)preguntasExamenData.get("id_examen"));
        preguntaExamen.setExamenesIdExamen(examenService.buscarPorId(id_examen).get());

        Long id_pregunta = Long.parseLong((String)preguntasExamenData.get("id_pregunta"));
        preguntaExamen.setPreguntasIdPregunta(preguntaService.buscarPorId(id_pregunta).get());

        Long porcentajePregunta = Long.parseLong((String)preguntasExamenData.get("porcentajePregunta"));
        preguntaExamen.setPorcentajePregunta(porcentajePregunta);

        try {
            return ResponseEntity.ok().body(preguntaExamenService.guardar(preguntaExamen));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarPreguntasExamen")
    public ResponseEntity<?> listarPreguntasExamen() {
        return ResponseEntity.ok().body(preguntaExamenService.buscarTodos());
    }

    @DeleteMapping("/eliminarPreguntasExamen")
    public ResponseEntity<?> eliminarPreguntasExamen(@RequestBody Map<String, Object> preguntasExamenData) {
        Long id_pregunta_examen = Long.parseLong((String)preguntasExamenData.get("id_pregunta_examen"));
        try{
            preguntaExamenService.eliminarPorId(id_pregunta_examen);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Pregunta Examen eliminada");
    }

    @PostMapping("/preguntasEstudiante")
    public ResponseEntity<?> registrarPreguntasEstudiante(@RequestBody Map<String, Object> preguntasEstudianteData) {
        PreguntaEstudiante preguntaEstudiante = new PreguntaEstudiante();

        Long id_presentacion = Long.parseLong((String)preguntasEstudianteData.get("id_presentacion"));
        preguntaEstudiante.setIdPresentacion(examenPresentadoService.buscarPorId(id_presentacion).get());

        Long id_pregunta_examen = Long.parseLong((String)preguntasEstudianteData.get("id_pregunta_examen"));
        preguntaEstudiante.setIdPreguntaExamen(preguntaExamenService.buscarPorId(id_pregunta_examen).get());

        try {
            return ResponseEntity.ok().body(preguntaEstudianteService.guardar(preguntaEstudiante));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarPreguntasEstudiante")
    public ResponseEntity<?> listarPreguntasEstudiante() {
        return ResponseEntity.ok().body(preguntaEstudianteService.buscarTodos());
    }

    @DeleteMapping("/eliminarPreguntasEstudiante")
    public ResponseEntity<?> eliminarPreguntasEstudiante(@RequestBody Map<String, Object> preguntasEstudianteData) {
        Long id_pregunta_estudiante = Long.parseLong((String) preguntasEstudianteData.get("id_pregunta_estudiante"));
        try {
            preguntaEstudianteService.eliminarPorId(id_pregunta_estudiante);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Pregunta Estudiante eliminada");
    }

    @PostMapping("/respuestasEstudiante")
    public ResponseEntity<?> registrarRespuestasEstudiante(@RequestBody Map<String, Object> respuestasEstudianteData) {
        RespuestaEstudiante respuestaEstudiante = new RespuestaEstudiante();

        respuestaEstudiante.setTexto((String) respuestasEstudianteData.get("texto"));
        respuestaEstudiante.setRespuesta((String) respuestasEstudianteData.get("respuesta"));

        Long id_pregunta_estudiante = Long.parseLong((String) respuestasEstudianteData.get("id_pregunta_estudiante"));
        respuestaEstudiante.setIdPreguntaEstudiante(preguntaEstudianteService.buscarPorId(id_pregunta_estudiante).get());

        try {
            return ResponseEntity.ok().body(respuestaEstudianteService.guardar(respuestaEstudiante));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listarRespuestasEstudiante")
    public ResponseEntity<?> listarRespuestasEstudiante() {
        return ResponseEntity.ok().body(respuestaEstudianteService.buscarTodos());
    }

    @DeleteMapping("/eliminarRespuestasEstudiante")
    public ResponseEntity<?> eliminarRespuestasEstudiante(@RequestBody Map<String, Object> respuestasEstudianteData) {
        Long id_respuesta_estudiante = Long.parseLong((String) respuestasEstudianteData.get("id_respuesta_estudiante"));
        try {
            respuestaEstudianteService.eliminarPorId(id_respuesta_estudiante);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Pregunta Estudiante eliminada");
    }

    @GetMapping("/listarExamenesPorGrupo")
    public ResponseEntity<?> listarExamenesPorGrupo(@RequestBody Map<String, Object> grupoData) {
        try {
            Long id_grupo = Long.parseLong((String)grupoData.get("id_grupo"));
            return ResponseEntity.ok().body(examenService.buscarExamenPorGrupo(id_grupo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarExamenPorId")
    public ResponseEntity<?> buscarExamenPorId(@RequestBody Map<String, Object> examenData) {
        try {
            Long id_examen = Long.parseLong((String)examenData.get("id_examen"));
            return ResponseEntity.ok().body(examenService.buscarPorId(id_examen));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarExamenesHistorial")
    public ResponseEntity<?> buscarExamenesHistorial(@RequestBody Map<String, Object> historialData) {
        try {
            String id_estudiante = (String) historialData.get("id_estudiante");
            return ResponseEntity.ok().body(examenService.buscarExamenPorEstudiante(id_estudiante));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarExamenesPorProfesor")
    public ResponseEntity<?> buscarExamenesPorProfesor(@RequestBody Map<String, Object> profesorData) {
        try {
            String id_profesor = (String) profesorData.get("id_profesor");
            return ResponseEntity.ok().body(examenService.buscarExamenPorProfesor(id_profesor));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
