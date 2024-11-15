package org.example.micromonopatin.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonopatinResponseDTO {
    private Long id;
    private int kmTotales;
    private double latitud;
    private double longitud;
    private boolean enMantenimiento;
    private int kmParaMantenimiento;
    private int tiempoDeUso;
    private int tiempoEnPausa;
}