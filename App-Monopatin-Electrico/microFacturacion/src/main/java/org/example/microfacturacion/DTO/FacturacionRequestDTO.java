package org.example.microfacturacion.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturacionRequestDTO {

    @NotNull(message = "La latitud es un campo obligatorio.")
    @NotEmpty(message= "No debe tener una latitud vacía")
    private Long latitud;

    @NotNull(message = "La longitud es un campo obligatorio.")
    @NotEmpty(message= "No debe tener una longitud vacía")
    private Long longitud;

    @NotNull(message = "El precio final es obligatorio.")
    @NotEmpty(message= "No debe tener un precioFinal sin determianr")
    private float precioFinal;
}
