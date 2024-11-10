package org.example.microestacion.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstacionResponseDTO {
    private Long id;
        private Long latitud;
        private Long longitud;
}
