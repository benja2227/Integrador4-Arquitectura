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
    private int kmTotales;
    @NotNull
    @NotEmpty
    private Long latitud;
    @NotNull
    @NotEmpty
    private Long longitud;
    @NotNull
    @NotEmpty
    private boolean enMantenimiento;
    @NotNull
    @NotEmpty
    private int kmMantenimiento;
}
