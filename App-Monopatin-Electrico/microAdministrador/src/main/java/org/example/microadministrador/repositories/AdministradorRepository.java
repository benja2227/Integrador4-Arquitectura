package org.example.microadministrador.repositories;

import org.example.microadministrador.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

        public List<Administrador> findByIdUsuario(Long usuariosPorId);
}
