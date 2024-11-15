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

// Viaje 2: Sin pausa, distancia moderada
        Viaje viaje2 = new Viaje(null,
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now().minusHours(5),
                40353454L, -38123876L, // Inicio: Estacion B
                40543321L, -38312300L, // Fin: Estacion C
                2L, 1L,
                null, null,
                12.50f);

// Viaje 3: Con pausa de 20 minutos, distancia larga
        Viaje viaje3 = new Viaje(null,
                LocalDateTime.now().minusHours(5),
                LocalDateTime.now().minusHours(4),
                40543321L, -38312300L, // Inicio: Estacion C
                40453000L, -38312000L, // Fin: Estacion D
                3L, 4L,
                LocalDateTime.now().minusHours(4).minusMinutes(20),
                LocalDateTime.now().minusHours(4),
                15.75f);

// Viaje 4: Sin pausa, distancia moderada
        Viaje viaje4 = new Viaje(null,
                LocalDateTime.now().minusDays(2),
                LocalDateTime.now().minusDays(2).plusHours(1),
                40453000L, -38312000L, // Inicio: Estacion D
                40353645L, -38123456L, // Fin: Estacion E
                4L, 5L,
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

// Viaje 6: Con pausa de 10 minutos, distancia corta
        Viaje viaje6 = new Viaje(null,
                LocalDateTime.now().minusDays(3),
                LocalDateTime.now().minusDays(3).plusHours(1),
                40454000L, -38312100L, // Inicio: Estacion F
                40353645L, -38123456L, // Fin: Estacion E
                5L, 6L,
                LocalDateTime.now().minusMinutes(40),
                LocalDateTime.now().minusMinutes(30),
                9.00f);

// Viaje 7: Con pausa de 5 minutos, distancia corta
        Viaje viaje7 = new Viaje(null,
                LocalDateTime.now().minusHours(8),
                LocalDateTime.now().minusHours(7),
                40543212L, -38312415L, // Inicio: Estacion A
                40353454L, -38123876L, // Fin: Estacion B
                7L, 8L,
                LocalDateTime.now().minusMinutes(15),
                LocalDateTime.now().minusMinutes(10),
                7.50f);

// Viaje 8: Con pausa de 40 minutos, distancia larga
        Viaje viaje8 = new Viaje(null,
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now().minusHours(7),
                40543321L, -38312300L, // Inicio: Estacion C
                40453000L, -38312000L, // Fin: Estacion D
                2L, 4L,
                LocalDateTime.now().minusHours(6).minusMinutes(40),
                LocalDateTime.now().minusHours(6),
                30.00f);

// Viaje 9: Con pausa de 1 hora, distancia larga
        Viaje viaje9 = new Viaje(null,
                LocalDateTime.now().minusDays(2),
                LocalDateTime.now().minusDays(2).plusHours(2),
                40453000L, -38312000L, // Inicio: Estacion D
                40353645L, -38123456L, // Fin: Estacion E
                3L, 2L,
                LocalDateTime.now().minusHours(2).minusMinutes(55),
                LocalDateTime.now().minusMinutes(5),
                18.00f);

// Viaje 10: Sin pausa, distancia moderada
        Viaje viaje10 = new Viaje(null,
                LocalDateTime.now().minusYears(1).minusDays(1),
                LocalDateTime.now().minusYears(1).minusDays(1).plusHours(1),
                40543212L, -38312415L, // Inicio: Estacion A
                40353454L, -38123876L, // Fin: Estacion B
                8L, 9L,
                null, null,
                12.00f);

// Viaje 11: Con pausa de 25 minutos, distancia larga
        Viaje viaje11 = new Viaje(null,
                LocalDateTime.now().minusYears(1).minusDays(1),
                LocalDateTime.now().minusYears(1).minusDays(1).plusHours(2),
                40353645L, -38123456L, // Inicio: Estacion E
                40454000L, -38312100L, // Fin: Estacion F
                9L, 10L,
                LocalDateTime.now().minusHours(2).minusMinutes(25),
                LocalDateTime.now().minusHours(2),
                22.00f);

// Viaje 12: Con pausa de 15 minutos, distancia moderada
        Viaje viaje12 = new Viaje(null,
                LocalDateTime.now().minusYears(2),
                LocalDateTime.now().minusYears(2).plusDays(1).plusHours(2),
                40543321L, -38312300L, // Inicio: Estacion C
                40453000L, -38312000L, // Fin: Estacion D
                10L, 1L,
                LocalDateTime.now().minusHours(1).minusMinutes(15),
                LocalDateTime.now().minusHours(1),
                16.00f);

// Guardar los viajes
        viajeRepository.save(viaje1);
        viajeRepository.save(viaje2);
        viajeRepository.save(viaje3);
        viajeRepository.save(viaje4);
        viajeRepository.save(viaje5);
        viajeRepository.save(viaje6);
        viajeRepository.save(viaje7);
        viajeRepository.save(viaje8);
        viajeRepository.save(viaje9);
        viajeRepository.save(viaje10);
        viajeRepository.save(viaje11);
        viajeRepository.save(viaje12);

        System.out.println("Datos iniciales cargados en la base de datos para microViaje.");
    }
}