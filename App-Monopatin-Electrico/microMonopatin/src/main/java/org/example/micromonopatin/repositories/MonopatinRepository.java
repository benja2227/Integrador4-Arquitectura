package org.example.micromonopatin.repositories;

import org.example.micromonopatin.entities.Monopatin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonopatinRepository extends JpaRepository<Monopatin,Long> {

    @Query("SELECT m.id, m.kmTotales FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteKilometraje();

    @Query("SELECT m.id, m.tiempoDeUso FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteTiempoConPausas();

    @Query("SELECT m.id, (m.tiempoDeUso - m.tiempoEnPausa) FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteTiempoSinPausas();

    @Query("SELECT " +
            "(SELECT COUNT(m1) FROM Monopatin m1 WHERE m1.enMantenimiento = true), " +
            "(SELECT COUNT(m2) FROM Monopatin m2 WHERE m2.enMantenimiento = false) " +
            "FROM Monopatin m")
    Object[] contarMonopatines();


}