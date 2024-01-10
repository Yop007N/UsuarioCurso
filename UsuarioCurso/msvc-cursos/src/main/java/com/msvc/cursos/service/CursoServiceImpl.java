package com.msvc.cursos.service;

import com.msvc.cursos.model.entity.Curso;
import com.msvc.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso crearCurso(Curso curso) {
        // Aquí puedes agregar lógica adicional antes de guardar en el repositorio
        return cursoRepository.save(curso);
    }

    @Override
    public Curso obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
    }

    @Override
    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso actualizarCurso(Curso curso) {
        // Verificar si el curso existe antes de actualizar
        if (!cursoRepository.existsById(curso.getId())) {
            throw new RuntimeException("Curso no encontrado con ID: " + curso.getId());
        }

        // Aquí puedes agregar lógica adicional antes de actualizar en el repositorio
        return cursoRepository.save(curso);
    }

    @Override
    public void eliminarCurso(Long id) {
        // Verificar si el curso existe antes de eliminar
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso no encontrado con ID: " + id);
        }

        cursoRepository.deleteById(id);
    }
}
