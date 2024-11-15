package org.example.microadministrador.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturacionParamDTO {
    private int mesInicio;
    private int mesFin;
    private int anio;
}
