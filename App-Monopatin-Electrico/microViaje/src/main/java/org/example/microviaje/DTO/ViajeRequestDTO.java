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
public class ViajeRequestDTO {

    @NotNull(message = "El campo inicio es obligatorio.")
    @NotEmpty(message = "El campo inicio no  puede estar vacío")
    private LocalDateTime inicio;

    @NotNull(message = "El campo fin es obligatorio.")
    @NotEmpty(message = "El campo fin no  puede estar vacío")
    private LocalDateTime fin;

    @NotNull(message = "El campo usuario es obligatorio.")
    @NotEmpty(message = "El campo usuario no  puede estar vacío")
    private Long id_usuario;

    @NotNull(message = "El campo monopatin es obligatorio.")
    @NotEmpty(message = "El campo monopatin no  puede estar vacío")
    private Long id_monopatin;

    @NotNull(message = "El campo kmRecorridos es obligatorio.")
    @NotEmpty(message = "El campo kmRecorridos no  puede estar vacío")
    private int kmRecorridos;
}
