package org.example.microusuario.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



import java.util.List;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    private Long id;
    @NotNull
    @NotEmpty
    private String nombre;
    @NotNull
    @NotEmpty
    private String apellido;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String telefono;

}



