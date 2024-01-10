package com.msvc.cursos.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario_curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
}
