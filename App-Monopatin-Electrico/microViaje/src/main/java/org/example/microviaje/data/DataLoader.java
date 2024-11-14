package org.example.microviaje.data;

import org.example.microviaje.entities.Viaje;
import org.example.microviaje.repositories.ViajeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final ViajeRepository viajeRepository;

    public DataLoader(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Viaje 1: Sin pausa, distancia moderada
        Viaje viaje1 = new Viaje(null,
                LocalDateTime.now().minusHours(2),
                LocalDateTime.now(),
                40543212L, -38312415L, // Inicio: Estacion A
                40353454L, -38123876L, // Fin: Estacion B
                1L, 2L,
                null, null,
                10.00f);

        Viaje viaje2 = new Viaje(null,
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now().minusHours(5),
                40353454L, -38123876L, // Inicio: Estacion B
                40543321L, -38312300L, // Fin: Estacion C
                3L, 4L,
                null, null,
                12.50f);

// Viaje 3: Con pausa de 20 minutos, distancia larga
        Viaje viaje3 = new Viaje(null,
                LocalDateTime.now().minusHours(5),
                LocalDateTime.now().minusHours(4),
                40543321L, -38312300L, // Inicio: Estacion C
                40453000L, -38312000L, // Fin: Estacion D
                4L, 5L,
                LocalDateTime.now().minusHours(4).minusMinutes(20),
                LocalDateTime.now().minusHours(4),
                15.75f);

// Viaje 4: Sin pausa, distancia moderada
        Viaje viaje4 = new Viaje(null,
                LocalDateTime.now().minusDays(2),
                LocalDateTime.now().minusDays(2).plusHours(1),
                40453000L, -38312000L, // Inicio: Estacion D
                40353645L, -38123456L, // Fin: Estacion E
                5L, 6L,
                null, null,
                8.25f);

// Viaje 5: Con pausa de 30 minutos, distancia larga
        Viaje viaje5 = new Viaje(null,
                LocalDateTime.now().minusHours(6),
                LocalDateTime.now().minusHours(5),
                40353645L, -38123456L, // Inicio: Estacion E
                40454000L, -38312100L, // Fin: Estacion F
                6L, 7L,
                LocalDateTime.now().minusHours(5).minusMinutes(30),
                LocalDateTime.now().minusHours(5).minusMinutes(10),
                20.50f);

// Guardar los viajes
        viajeRepository.save(viaje1);
        viajeRepository.save(viaje2);
        viajeRepository.save(viaje3);
        viajeRepository.save(viaje4);
        viajeRepository.save(viaje5);


        System.out.println("Datos iniciales cargados en la base de datos para microViaje.");
    }
}