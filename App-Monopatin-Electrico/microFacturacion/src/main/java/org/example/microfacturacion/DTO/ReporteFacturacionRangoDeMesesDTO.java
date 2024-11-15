package org.example.microfacturacion.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteFacturacionRangoDeMesesDTO {
    private Float precio;
    private int mesInicio;
    private int mesFinal;
    private int anio;
}