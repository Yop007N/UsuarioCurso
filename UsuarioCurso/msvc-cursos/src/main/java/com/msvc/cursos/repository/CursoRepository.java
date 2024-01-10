package com.msvc.cursos.repository;

import com.msvc.cursos.model.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
