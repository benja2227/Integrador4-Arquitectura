package org.example.microestacion.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstacionRequestDTO {
@NotNull(message = "El id no puede ser nulo")
@NotEmpty (message = "El id no puede estar vacío")
private Long id;

    @NotNull(message = "La latitud es un campo obligatorio.")
    @NotEmpty (message = "La latitud no puede estar vacía")
    private Long latitud;

    @NotNull(message = "La longitud es un campo obligatorio.")
    @NotEmpty (message = "La longitudno puede estar vacía")
    private Long longitud;
}
