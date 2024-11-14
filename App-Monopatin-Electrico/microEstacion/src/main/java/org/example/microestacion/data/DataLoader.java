package org.example.microestacion.data;

import org.example.microestacion.entities.Estacion;
import org.example.microestacion.repositories.EstacionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EstacionRepository estacionRepository;

    public DataLoader(EstacionRepository estacionRepository) {
        this.estacionRepository = estacionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Estacion estacion1 = new Estacion(null, 40543212L, -38312415L); // Parada A
        Estacion estacion2 = new Estacion(null, 40353454L, -38123876L); // Parada B
        Estacion estacion3 = new Estacion(null, 40543321L, -38312300L); // Parada C
        Estacion estacion4 = new Estacion(null, 40453000L, -38312000L); // Parada D
        Estacion estacion5 = new Estacion(null, 40353645L, -38123456L); // Parada E
        Estacion estacion6 = new Estacion(null, 40454000L, -38312100L); // Parada F

        estacionRepository.save(estacion1);
        estacionRepository.save(estacion2);
        estacionRepository.save(estacion3);
        estacionRepository.save(estacion4);
        estacionRepository.save(estacion5);
        estacionRepository.save(estacion6);


        System.out.println("Datos iniciales cargados en la base de datos para microEstacion.");
    }
}