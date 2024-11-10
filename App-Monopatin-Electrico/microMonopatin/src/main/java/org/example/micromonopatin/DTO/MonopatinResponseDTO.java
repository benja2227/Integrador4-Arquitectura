package org.example.micromonopatin.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonopatinResponseDTO {

    private int kmTotales;
    private Long latitud;
    private Long longitud;
    private int tiempoEnPausa;
    private boolean enMantenimiento;
}
