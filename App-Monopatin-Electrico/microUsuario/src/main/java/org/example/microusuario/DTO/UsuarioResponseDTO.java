package org.example.microusuario.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class UsuarioResponseDTO  {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private double latitud;
    private double Longitud;


}