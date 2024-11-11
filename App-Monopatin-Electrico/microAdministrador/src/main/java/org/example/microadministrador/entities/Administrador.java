package org.example.microadministrador.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private float precio;
    @NotNull
    @NotEmpty
    private float precioEspecial;
    @NotNull
    @NotEmpty
    private LocalDate fecha;

}
