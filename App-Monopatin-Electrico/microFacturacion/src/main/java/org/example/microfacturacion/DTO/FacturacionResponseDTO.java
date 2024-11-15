package org.example.microfacturacion.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturacionResponseDTO {

    private Long id;

    private Long latitud;

    private Long longitud;

    private float precioFinal;

    private LocalDate fechaFacturacion;


}
