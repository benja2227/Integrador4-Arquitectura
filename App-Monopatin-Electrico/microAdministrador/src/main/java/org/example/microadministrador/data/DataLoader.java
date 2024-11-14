package org.example.microadministrador.data;


import org.example.microadministrador.entities.Administrador;
import org.example.microadministrador.repositories.AdministradorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final AdministradorRepository administradorRepository;

    public DataLoader(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Cargar datos iniciales
        Administrador admin1 = new Administrador(null, 100.0f, 80.0f, LocalDateTime.now(), 100);
        Administrador admin2 = new Administrador(null, 150.0f, 120.0f, LocalDateTime.now().plusDays(5), 500);

        administradorRepository.save(admin1);
        administradorRepository.save(admin2);

        System.out.println("Datos iniciales cargados en la base de datos.");
    }
}