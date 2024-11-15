package org.example.micromonopatin.repositories;

import org.example.micromonopatin.entities.Monopatin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MonopatinRepository extends JpaRepository<Monopatin,Long> {

    @Query("SELECT m.id, m.kmTotales FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteKilometraje();

    @Query("SELECT m.id, m.tiempoDeUso FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteTiempoConPausas();

    @Query("SELECT m.id, (m.tiempoDeUso - m.tiempoEnPausa) FROM Monopatin m GROUP BY m.id")
    List<Object[]> reporteTiempoSinPausas();

    @Query("SELECT COUNT(m) FROM Monopatin m WHERE m.enMantenimiento = :estado")
    Long contarMonopatinesPorEstado(@Param("estado") boolean estado);

    @Query("SELECT m FROM Monopatin m " +
            "WHERE m.latitud BETWEEN :latitudUsuario - :rango AND :latitudUsuario + :rango " +
            "AND m.longitud BETWEEN :longitudUsuario - :rango AND :longitudUsuario + :rango " +
            "AND m.enMantenimiento = false")
    List<Monopatin> getReporteDeMonopatinesCercanos(@Param("latitudUsuario") double latitudUsuario,
                                                    @Param("longitudUsuario") double longitudUsuario,
                                                    @Param("rango") double rango);
}