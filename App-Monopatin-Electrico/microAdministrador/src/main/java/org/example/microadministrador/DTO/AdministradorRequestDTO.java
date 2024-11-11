package org.example.microadministrador.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorRequestDTO {
    @NotNull(message = "El ID es obligatorio.")
    private Long id;

    @NotNull(message = "El precio es obligatorio.")
    private float precio;

    @NotNull(message = "El precio especial es obligatorio.")
    private float precioEspecial;

    @NotNull(message = "La fecha es obligatoria.")
    private LocalDate fecha;

}
