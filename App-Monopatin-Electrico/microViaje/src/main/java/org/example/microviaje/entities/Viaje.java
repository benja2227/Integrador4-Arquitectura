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
    private Long id_usuario;
    @NotNull
    @NotEmpty
    private Long id_monopatin;
    @NotNull
    @NotEmpty
    private int kmRecorridos;
    @NotNull
    @NotEmpty
    private int tiempoEnPausa;
}
