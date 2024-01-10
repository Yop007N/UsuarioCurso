package com.msvc.cursos.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del curso no puede estar en blanco")
    @Size(min = 3, max = 100, message = "El nombre del curso debe tener entre 3 y 100 caracteres")
    private String nombre;

    @Email(message = "Ingrese una dirección de correo electrónico válida")
    @Column(unique = true)
    private String correoInstructor;

    @Min(value = 1, message = "La duración del curso debe ser al menos 1 día")
    @Max(value = 365, message = "La duración del curso no puede exceder los 365 días")
    private int duracionDias;

    @PositiveOrZero(message = "La calificación no puede ser negativa")
    @Max(value = 10, message = "La calificación máxima permitida es 10")
    private double calificacion;

    @ElementCollection
    @CollectionTable(
            name = "usuario_curso",
            joinColumns = @JoinColumn(name = "curso_id")
    )
    @Column(name = "usuario_id")
    private List<Long> usuariosInscritos;
}
