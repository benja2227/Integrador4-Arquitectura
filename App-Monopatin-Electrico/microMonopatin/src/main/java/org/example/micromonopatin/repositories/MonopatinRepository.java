package org.example.micromonopatin.repositories;

import org.example.micromonopatin.entities.Monopatin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonopatinRepository extends JpaRepository<Monopatin,Long> {

    @Query("SELECT m.id, SUM(m.kmTotales) FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteKilometraje();

    @Query("SELECT m.id, SUM(m.kmMantenimiento) FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteTiempoConPausas();

    @Query("SELECT m.id, (SUM(m.kmTotales) - SUM(m.kmTotales)) FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteTiempoSinPausas();


}
