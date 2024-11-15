package org.example.microfacturacion.repositories;

import org.example.microfacturacion.entities.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface FacturacionRepository extends JpaRepository<Facturacion,Long> {
    @Query("SELECT SUM(f.precioFinal) FROM Facturacion f WHERE FUNCTION('YEAR', f.fechaFacturacion) = :anio AND FUNCTION('MONTH', f.fechaFacturacion) BETWEEN :mesInicio AND :mesFin")
    Float generarReporteDeFacturacion(@Param("anio") int anio,
                                      @Param("mesInicio") int mesInicio,
                                      @Param("mesFin") int mesFin);

}