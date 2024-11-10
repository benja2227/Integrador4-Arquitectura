package org.example.microcuenta.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaResponseDTO {

    private Long usuariosPorId;

    private LocalDate fechaAlta;

    private float saldo;
}