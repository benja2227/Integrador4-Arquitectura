package org.example.microcuenta.repositories;

import org.example.microcuenta.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

        @Query("SELECT c FROM Cuenta c WHERE c.id_usuario = :usuariosPorId")
        public List<Cuenta> findByIdUsuario(Long usuariosPorId);
}
