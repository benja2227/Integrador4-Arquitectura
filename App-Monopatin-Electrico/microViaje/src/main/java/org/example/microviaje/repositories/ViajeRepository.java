package org.example.microviaje.repositories;

import org.example.micromonopatin.entities.Monopatin;
import org.example.microviaje.entities.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeRepository extends JpaRepository<Viaje,Long> {
}
