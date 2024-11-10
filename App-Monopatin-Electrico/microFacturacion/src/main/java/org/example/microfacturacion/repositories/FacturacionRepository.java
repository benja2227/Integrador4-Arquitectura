package org.example.microfacturacion.repositories;

import org.example.microfacturacion.entities.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturacionRepository extends JpaRepository<Facturacion,Long> {
}
