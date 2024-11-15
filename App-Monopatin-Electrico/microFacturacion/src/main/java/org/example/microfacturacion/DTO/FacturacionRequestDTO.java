package org.example.microfacturacion.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturacionRequestDTO {
    @NotNull(message = "El campo id es obligatorio.")
    @NotEmpty(message= "El campo id es obligatorio")
    private Long id;

    @NotNull(message = "La latitud es un campo obligatorio.")
    @NotEmpty(message= "No debe tener una latitud vacía")
    private Long latitud;

    @NotNull(message = "La longitud es un campo obligatorio.")
    @NotEmpty(message= "No debe tener una longitud vacía")
    private Long longitud;

    @NotNull(message = "El precio final es obligatorio.")
    @NotEmpty(message= "No debe tener un precioFinal sin determianr")
    private float precioFinal;

    @NotNull(message = "La fecha de facturacion es obligatorio.")
    @NotEmpty(message= "No debe tener una fecha de facturacion sin determianr")
    private LocalDate fechaFacturacion;
}
