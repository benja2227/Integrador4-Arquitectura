package org.example.micromantenimiento.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MantenimientoResponseDTO {
    private Long IDmonopatin;
    private LocalDate fechaMantenimiento;
    private int topeKm;
}




