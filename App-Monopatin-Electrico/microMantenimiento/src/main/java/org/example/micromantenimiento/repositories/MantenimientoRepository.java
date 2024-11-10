package org.example.micromantenimiento.repositories;

import org.example.micromantenimiento.entities.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento,Long> {
}
