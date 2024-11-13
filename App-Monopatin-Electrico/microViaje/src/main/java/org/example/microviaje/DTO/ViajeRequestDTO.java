package org.example.microviaje.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViajeRequestDTO {

    @NotNull(message = "El campo id es obligatorio.")
    @NotEmpty(message = "El campo id no  puede estar vacío")
    private Long id;

    @NotNull(message = "El campo inicio es obligatorio.")
    @NotEmpty(message = "El campo inicio no  puede estar vacío")
    private LocalDateTime inicio;

    @NotNull(message = "El campo fin es obligatorio.")
    @NotEmpty(message = "El campo fin no  puede estar vacío")
    private LocalDateTime fin;

    @NotNull(message = "El campo latitudInicio es obligatorio.")
    @NotEmpty(message = "El campo latitudInicio no  puede estar vacío")
    private Long latitudInicio;

    @NotNull(message = "El campo longitudInicio es obligatorio.")
    @NotEmpty(message = "El campo longitudInicio no  puede estar vacío")
    private Long longitudInicio;

    @NotNull(message = "El campo latitudFin es obligatorio.")
    @NotEmpty(message = "El campo latitudFin no  puede estar vacío")
    private Long latitudFin;

    @NotNull(message = "El campo longitudFin es obligatorio.")
    @NotEmpty(message = "El campo longitudFin no  puede estar vacío")
    private Long longitudFin;

    @NotNull(message = "El campo usuario es obligatorio.")
    @NotEmpty(message = "El campo usuario no  puede estar vacío")
    private Long id_usuario;

    @NotNull(message = "El campo monopatin es obligatorio.")
    @NotEmpty(message = "El campo monopatin no  puede estar vacío")
    private Long id_monopatin;


    @NotNull(message = "El campo incioEnPausa es obligatorio.")
    @NotEmpty(message = "El campo incioEnPausa no  puede estar vacío")
    private LocalDateTime incioEnPausa;

    @NotNull(message = "El campo finEnPausa es obligatorio.")
    @NotEmpty(message = "El campo finEnPausa no  puede estar vacío")
    private LocalDateTime finEnPausa;

    @NotNull(message = "El campo precioTotal es obligatorio.")
    @NotEmpty(message = "El campo precioTotal no  puede estar vacío")
    private Float precioTotal;



}
