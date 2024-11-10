package org.example.microusuario.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor


public class UsuarioRequestDTO {
    @NotEmpty(message="El campo id de usuario no puede estar vacío.")
    @NotNull(message = "El id es un campo obligatorio")
    private Long id;
    @NotEmpty(message="El campo nombre de usuario no puede estar vacío.")
    @NotNull(message = "El nombre es un campo obligatorio")
    private String nombre;
    @NotEmpty(message="El campo apellido de usuario no puede estar vacío.")
    @NotNull(message = "El apellido es un campo obligatorio")
    private String apellido;
    @NotNull(message = "El email es obligatorio")
    private String email;
    @NotNull(message = "El teléfono es obligatorio")
    private String telefono;

}
