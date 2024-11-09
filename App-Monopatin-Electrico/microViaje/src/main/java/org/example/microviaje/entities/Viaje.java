package org.example.microviaje.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    private Usuario usuario;
    @NotNull
    @NotEmpty
    private Monopatin monopatin;
    @NotNull
    @NotEmpty
    private int kmRecorridos;
}
