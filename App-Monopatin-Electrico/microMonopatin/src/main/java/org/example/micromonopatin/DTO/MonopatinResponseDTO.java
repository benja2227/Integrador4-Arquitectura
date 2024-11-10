package org.example.micromonopatin.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    private int kmMantenimiento;
}
