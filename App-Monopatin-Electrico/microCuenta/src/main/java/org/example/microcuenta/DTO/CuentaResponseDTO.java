package org.example.microcuenta.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaResponseDTO {

    private Long id;

    private Long id_usuario;

    private LocalDate fechaAlta;

    private float saldo;
}