package org.example.micromantenimiento.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MantenimientoRequestDTO {
    @NotNull(message = "El ID del monopatín es obligatorio")
    private Long IDmonopatin;

    @NotNull(message = "La fecha de mantenimiento es obligatoria")
    private LocalDate fechaMantenimiento;

    @NotNull(message = "El tope de kilómetros es obligatorio")
    private int topeKm;
}
