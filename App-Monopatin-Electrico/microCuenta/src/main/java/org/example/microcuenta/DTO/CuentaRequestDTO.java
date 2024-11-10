package org.example.microcuenta.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaRequestDTO {

    @NotNull(message = "El ID del usuario es obligatorio.")
    private Long usuariosPorId;

    @NotNull(message = "La fecha de alta es obligatoria.")
    private LocalDate fechaAlta;

    private float saldo;
}
