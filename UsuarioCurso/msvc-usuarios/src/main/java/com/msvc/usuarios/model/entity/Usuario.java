package com.msvc.usuarios.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuarios")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(max = 100, message = "La longitud del nombre no puede superar los 100 caracteres")
    private String nombre;

    @Email(message = "Debe ser una dirección de correo electrónico válida")
    private String correo;

    @PositiveOrZero(message = "La edad no puede ser negativa")
    private int edad;

    @Pattern(regexp = "[0-9]{10}", message = "El número de teléfono debe tener 10 dígitos")
    private String telefono;

    @DecimalMin(value = "0.01", message = "El saldo no puede ser menor que 0.01")
    private double saldo;

}
