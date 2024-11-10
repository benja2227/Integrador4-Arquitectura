package org.example.micromantenimiento.entities;

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

public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private Long IDmonopatin;
    @NotNull
    @NotEmpty
    private LocalDate fechaMantenimiento;
    @NotNull
    @NotEmpty
    private int topeKm;
}
