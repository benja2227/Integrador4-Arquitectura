package org.example.microadministrador.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonopatinDTO {
    private Long id;
    private int kmTotales;
    private Long latitud;
    private Long longitud;
    private boolean enMantenimiento;
    private Long kmParaMantenimiento;
    private int tiempoDeUso;
    private int tiempoEnPausa;
}