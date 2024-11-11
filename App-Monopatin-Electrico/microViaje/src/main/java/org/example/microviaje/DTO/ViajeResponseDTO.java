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

    private Long id;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Long latitudInicio;
    private Long longitudInicio;
    private Long latitudFin;
    private Long longitudFin;
    private Long id_usuario;
    private Long id_monopatin;
    private LocalDateTime incioEnPausa;
    private LocalDateTime finEnPausa;
    private double precioTotal;



}
