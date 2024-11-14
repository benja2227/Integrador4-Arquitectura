package org.example.microviaje.repositories;
import feign.Param;

import org.example.microviaje.entities.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ViajeRepository extends JpaRepository<Viaje,Long> {
    @Query("SELECT v.id_monopatin FROM Viaje v " +
            "WHERE v.inicio >= :inicioAnio AND v.inicio < :finAnio " +
            "GROUP BY v.id_monopatin " +
            "HAVING COUNT(v) > :cantViajes")
    List<Long> getMonopatinByCantViajeYAnio(@Param("cantViajes") int cantViajes,
                                                 @Param("inicioAnio") LocalDateTime inicioAnio,
                                                 @Param("finAnio") LocalDateTime finAnio);
}