package org.example.microadministrador.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteMonopatinMantenimientoDTO implements ReporteMonopatinMantDTO{

    @NotNull(message = "El ID es obligatorio.")
    private Long idMonopatin;
    @NotNull(message = "El Km totales es obligatorio.")
    private Long kmTotales;
    @NotNull(message = "El tope de Km es obligatorio.")
    private Integer topeKm;
    @NotNull(message = "Si necesita mantenimiento es obligatorio.")
    private boolean necesitaMantenimiento;
}