package org.example.micromonopatin.data;

import org.example.micromonopatin.entities.Monopatin;
import org.example.micromonopatin.repositories.MonopatinRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final MonopatinRepository monopatinRepository;

    public DataLoader(MonopatinRepository monopatinRepository) {
        this.monopatinRepository = monopatinRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Cargar datos iniciales
        Monopatin monopatin1 = new Monopatin(1L, 1500, 40543212L, -38312415L, false, 0, 0, 0);
        Monopatin monopatin2 = new Monopatin(2L, 2300, 40353454L, -38123876L, true, 100, 0, 0);
        Monopatin monopatin3 = new Monopatin(3L, 3200, 40543321L, -38312300L, false, 200, 0, 0);
        Monopatin monopatin4 = new Monopatin(4L, 2100, 40453000L, -38312000L, true, 50, 0, 0);
        Monopatin monopatin5 = new Monopatin(5L, 1800, 40353645L, -38123456L, false, 0, 0, 0);
        Monopatin monopatin6 = new Monopatin(6L, 2500, 40454000L, -38312100L, true, 120, 0, 0);
        Monopatin monopatin7 = new Monopatin(7L, 3000, 40543212L, -38312415L, false, 0, 0, 0);
        Monopatin monopatin8 = new Monopatin(8L, 2800, 40353454L, -38123876L, true, 80, 0, 0);
        Monopatin monopatin9 = new Monopatin(9L, 2600, 40543321L, -38312300L, false, 150, 0, 0);
        Monopatin monopatin10 = new Monopatin(10L, 2200, 40453000L, -38312000L, true, 40, 0, 0);

        monopatinRepository.save(monopatin1);
        monopatinRepository.save(monopatin2);
        monopatinRepository.save(monopatin3);
        monopatinRepository.save(monopatin4);
        monopatinRepository.save(monopatin5);
        monopatinRepository.save(monopatin6);
        monopatinRepository.save(monopatin7);
        monopatinRepository.save(monopatin8);
        monopatinRepository.save(monopatin9);
        monopatinRepository.save(monopatin10);

        System.out.println("Datos iniciales cargados en la base de datos para microMonopatin.");
    }
}