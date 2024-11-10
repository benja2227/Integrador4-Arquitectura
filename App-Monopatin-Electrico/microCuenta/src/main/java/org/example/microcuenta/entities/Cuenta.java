package org.example.microcuenta.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Cuenta {
    @Id
    private Long id;
    @NotNull
    @NotEmpty
    private Long usuariosPorId;
    @NotNull
    @NotEmpty
    private LocalDate fechaAlta;
    private float saldo;
}
