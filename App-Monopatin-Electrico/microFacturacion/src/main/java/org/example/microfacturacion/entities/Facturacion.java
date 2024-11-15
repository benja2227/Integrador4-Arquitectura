package org.example.microfacturacion.entities;


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
public class Facturacion {
    @Id
    private Long id;
    @NotNull
    @NotEmpty
    private Long latitud;
    @NotNull
    @NotEmpty
    private Long longitud;
    @NotNull
    @NotEmpty
    private Float precioFinal;
    @NotNull
    @NotEmpty
    private LocalDate fechaFacturacion;

}