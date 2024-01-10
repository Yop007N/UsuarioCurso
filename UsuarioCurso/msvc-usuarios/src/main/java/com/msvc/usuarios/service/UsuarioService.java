package com.msvc.usuarios.service;

import com.msvc.usuarios.model.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario crearUsuario(Usuario usuario);

    Usuario obtenerUsuarioPorId(Long id);

    List<Usuario> obtenerUsuarios();

    Usuario actualizarUsuario(Long id, Usuario usuario);

    void eliminarUsuario(Long id);
}
