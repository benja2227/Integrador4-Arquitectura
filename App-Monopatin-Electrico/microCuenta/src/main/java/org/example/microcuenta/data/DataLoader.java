package org.example.microcuenta.data;

import org.example.microcuenta.entities.Cuenta;
import org.example.microcuenta.repositories.CuentaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final CuentaRepository cuentaRepository;

    public DataLoader(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Cargar datos iniciales
        Cuenta cuenta1 = new Cuenta(null, 1L, LocalDate.now(), 1000.0f, true);
        Cuenta cuenta2 = new Cuenta(null, 2L, LocalDate.now().minusDays(10), 500.0f, true);

        cuentaRepository.save(cuenta1);
        cuentaRepository.save(cuenta2);

        System.out.println("Datos iniciales cargados en la base de datos para microCuenta.");
    }
}