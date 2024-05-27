package com.example.proyectobasesspring.controllers;

import com.example.proyectobasesspring.services.implementations.ContenidoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contenidos")
@RequiredArgsConstructor
public class ContenidoController {

    private final ContenidoServiceImpl contenidoService;

    @GetMapping("/listarContenidos")
    public ResponseEntity<?> listarContenidos() {
        try {
            return ResponseEntity.ok().body(contenidoService.buscarTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
