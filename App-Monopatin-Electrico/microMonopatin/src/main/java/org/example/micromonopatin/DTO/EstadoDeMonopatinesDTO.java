package org.example.micromonopatin.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDeMonopatinesDTO {
    private Long monopatinesEnMantenimiento;
    private Long monopatinesEnServicio;
}