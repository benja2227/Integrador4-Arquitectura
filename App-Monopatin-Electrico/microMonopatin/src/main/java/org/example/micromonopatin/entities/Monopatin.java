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
    private Long id;

    @NotNull
    @NotEmpty
    private int kmTotales;

    @NotNull
    @NotEmpty
    private double latitud;
    @NotNull
    @NotEmpty
    private double longitud;
    @NotNull
    @NotEmpty
    private boolean enMantenimiento;
    @NotNull
    @NotEmpty
    // se debe poner 0, solo se debe hacer set en cada viaje del monopatin
    private int kmParaMantenimiento;

    // se debe poner 0, solo se debe hacer set en cada viaje del monopatin
    private int tiempoDeUso; //(tiempo en bruto)

    // se debe poner 0, solo se debe hacer set en cada viaje del monopatin
    private int tiempoEnPausa;

//    @OneToMany(mappedBy = "monopatin")
//    private List<Viaje> viajes;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull
//    private int kmTotales;  // El total de kilómetros recorridos (se acumula)
//
//    @NotNull
//    private Long latitud;
//
//    @NotNull
//    private Long longitud;
//
//    @NotNull
//    private boolean enMantenimiento;
//
//    private int kmMantenimiento;  // Los kilómetros realizados en mantenimiento (se acumula)
//
//    private int tiempoDeUso;  // El tiempo total de uso (se acumula)
//
//    private int tiempoEnPausa;  // El tiempo total en pausa (se acumula)
//
//    private int tiempoSinPausa;  // El tiempo sin pausa (se acumula)


}