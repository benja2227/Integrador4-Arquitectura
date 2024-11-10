package org.example.microviaje.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.micromonopatin.entities.Monopatin;
import org.example.microusuario.entities.Usuario;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViajeResponseDTO {
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Usuario usuario;
    private Monopatin monopatin;
    private int kmRecorridos;
}
