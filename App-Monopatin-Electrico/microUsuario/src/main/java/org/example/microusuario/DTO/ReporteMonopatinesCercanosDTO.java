package org.example.microusuario.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteMonopatinesCercanosDTO {
    private Long id;
    private double latitud;
    private  double longitud;
}