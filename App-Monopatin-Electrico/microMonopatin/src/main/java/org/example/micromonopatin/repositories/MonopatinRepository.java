package org.example.micromonopatin.repositories;

import org.example.micromonopatin.entities.Monopatin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonopatinRepository extends JpaRepository<Monopatin,Long> {

    // Generar reporte de uso de monopatines por kilómetros
    @Query("SELECT m.id, SUM(m.kmTotales) FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteKilometraje();

    // Generar reporte de uso de monopatines por tiempo con pausas
    @Query("SELECT m.id, SUM(m.tiempoEnPausa) FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteTiempoConPausas();


    // Generar reporte de uso de monopatines por tiempo sin pausas
    @Query("SELECT m.id, (SUM(m.kmTotales) - SUM(m.tiempoEnPausa)) FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteTiempoSinPausas();


}
