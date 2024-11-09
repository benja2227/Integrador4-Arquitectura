package org.example.micromonopatin.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Monopatin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private int kmRecorridos;
    @NotNull
    @NotEmpty
    private int latitud;
    @NotNull
    @NotEmpty
    private int longitud;
    @NotNull
    @NotEmpty
    private int tiempoEnPausa;
    @NotNull
    @NotEmpty
    private boolean enMantenimiento;
}
