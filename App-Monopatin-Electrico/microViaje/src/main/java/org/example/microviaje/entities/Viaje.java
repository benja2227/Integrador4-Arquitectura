package org.example.microviaje.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.micromonopatin.entities.Monopatin;
import org.example.microusuario.entities.Usuario;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private LocalDateTime inicio;
    @NotNull
    @NotEmpty
    private LocalDateTime fin;
    @NotNull
    @NotEmpty
    private Long latitudInicio;
    @NotNull
    @NotEmpty
    private Long longitudInicio;
    @NotNull
    @NotEmpty
    private Long latitudFin;
    @NotNull
    @NotEmpty
    private Long longitudFin;
    @NotNull
    @NotEmpty
    private Long id_usuario;
    @NotNull
    @NotEmpty
    private Long id_monopatin;
    @NotNull
    @NotEmpty
    private LocalDateTime incioEnPausa;
    @NotNull
    @NotEmpty
    private LocalDateTime finEnPausa;
    @NotNull
    @NotEmpty
    private double precioTotal;

}
