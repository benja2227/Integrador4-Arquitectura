package org.example.micromonopatin.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonopatinRequestDTO {
    @NotNull(message = "El campo kmTotales es obligatorio.")
    @NotEmpty(message = "El campo kmTotales no  puede estar vacío")
    private int kmTotales;

    @NotNull(message = "El campo latitud es obligatorio.")
    @NotEmpty(message = "El campo latitud no  puede estar vacío")
    private Long latitud;

    @NotNull(message = "El campo longitud es obligatorio.")
    @NotEmpty(message = "El campo longitud no  puede estar vacío")
    private Long longitud;

    @NotNull(message = "El campo enMantenimiento es obligatorio.")
    private boolean enMantenimiento;

    @NotNull(message = "El campo kmMantenimiento es obligatorio.")
    @NotEmpty(message = "El campo kmMantenimiento no  puede estar vacío")
    private int kmParaMantenimiento;

    @NotNull(message = "El campo tiempoEnPausa es obligatorio.")
    @NotEmpty(message = "El campo tiempoEnPausa no  puede estar vacío")
    private int tiempoDeUso;

    @NotNull(message = "El campo tiempoEnPausa es obligatorio.")
    @NotEmpty(message = "El campo tiempoEnPausa no  puede estar vacío")
    private int tiempoEnPausa;


}