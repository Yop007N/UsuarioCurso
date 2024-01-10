package com.msvc.cursos.controller;

import com.msvc.cursos.model.entity.Curso;
import com.msvc.cursos.service.CursoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
@Validated
public class CursoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);

    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@Valid @RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.crearCurso(curso);
        LOGGER.info("Nuevo curso creado con ID: {}", nuevoCurso.getId());
        return new ResponseEntity<>(nuevoCurso, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable @Min(1) Long id) {
        Curso curso = cursoService.obtenerCursoPorId(id);
        LOGGER.info("Curso encontrado con ID: {}", id);
        return ResponseEntity.ok(curso);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> obtenerTodosLosCursos() {
        List<Curso> cursos = cursoService.obtenerTodosLosCursos();
        LOGGER.info("Lista de cursos obtenida correctamente");
        return ResponseEntity.ok(cursos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable @Min(1) Long id, @Valid @RequestBody Curso curso) {
        curso.setId(id);
        Curso cursoActualizado = cursoService.actualizarCurso(curso);
        LOGGER.info("Curso actualizado con ID: {}", id);
        return ResponseEntity.ok(cursoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable @Min(1) Long id) {
        cursoService.eliminarCurso(id);
        LOGGER.info("Curso eliminado con ID: {}", id);
        return ResponseEntity.noContent().build();
    }

    // Manejo de excepciones global para la validación de datos
    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        LOGGER.error("Error en la solicitud: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
