package org.example.microcuenta.repositories;

import org.example.microcuenta.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    public List<Cuenta> findByUsuariosPorId(Long usuariosPorId);
}
