package com.msvc.cursos.service;

import com.msvc.cursos.model.entity.Curso;

import java.util.List;

public interface CursoService {

    Curso crearCurso(Curso curso);

    Curso obtenerCursoPorId(Long id);

    List<Curso> obtenerTodosLosCursos();

    Curso actualizarCurso(Curso curso);

    void eliminarCurso(Long id);
}
