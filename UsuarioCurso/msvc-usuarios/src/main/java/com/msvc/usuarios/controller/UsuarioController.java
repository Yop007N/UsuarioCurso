package com.msvc.usuarios.controller;

import com.msvc.usuarios.model.entity.Usuario;
import com.msvc.usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@Slf4j
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> crearUsuario(@Valid @RequestBody Usuario usuario) {
        usuarioService.crearUsuario(usuario);
        log.info("Usuario creado con éxito: {}", usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente.");
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
        log.info("Usuarios obtenidos con éxito.");
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        log.info("Usuario obtenido con éxito: {}", usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable Long id, @Validated @RequestBody Usuario usuario) {
        usuarioService.actualizarUsuario(id, usuario);
        log.info("Usuario actualizado con éxito: {}", usuario);
        return ResponseEntity.ok("Usuario actualizado exitosamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        log.info("Usuario eliminado con éxito. ID: {}", id);
        return ResponseEntity.ok("Usuario eliminado exitosamente.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        log.error("Error en la solicitud: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la solicitud.");
    }
}
