package org.example.microadministrador.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteFacturacionRangoDeMesesDTO {
    @NotNull(message = "El ID es obligatorio.")
    private Float precio;
    private int mesInicio;
    private int mesFinal;
    private int anio;
}