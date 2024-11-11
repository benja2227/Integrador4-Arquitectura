package org.example.microadministrador.services;



import jakarta.transaction.Transactional;
import org.example.microadministrador.DTO.AdministradorResponseDTO;
import org.example.microadministrador.DTO.AdministradorRequestDTO;
import org.example.microadministrador.entities.Administrador;
import org.example.microadministrador.repositories.AdministradorRepository;
import org.example.microadministrador.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<AdministradorResponseDTO> findAll() {
        List<Administrador> administradores = administradorRepository.findAll();
        return administradores.stream().map(this::mapToAdministradorResponseDTO).collect(Collectors.toList());
    }

    public AdministradorResponseDTO findById(Long id) {
        Administrador cuenta = administradorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("El administracion con ID " + id + " no fue encontrada")
        );
        return mapToAdministradorResponseDTO(cuenta);
    }

    @Transactional
    public AdministradorResponseDTO save(AdministradorRequestDTO administradorRequestDTO) {
        Administrador administrador = new Administrador();
        administrador.setId(administradorRequestDTO.getId());
        administrador.setPrecio(administradorRequestDTO.getPrecio());
        administrador.setPrecioEspecial(administradorRequestDTO.getPrecioEspecial());
        administrador.setFecha(administradorRequestDTO.getFecha());

        Administrador newAdministrador = administradorRepository.save(administrador);
        return mapToAdministradorResponseDTO(newAdministrador);
    }

    public AdministradorResponseDTO update(Long id, AdministradorRequestDTO administradorRequestDTO) {
        Administrador administrador = administradorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("El administrador con ID " + id + " no fue encontrada")
        );
        administrador.setId(administradorRequestDTO.getId());
        administrador.setPrecio(administradorRequestDTO.getPrecio());
        administrador.setPrecioEspecial(administradorRequestDTO.getPrecioEspecial());
        administrador.setFecha(administradorRequestDTO.getFecha());

        Administrador updateAdministrador = administradorRepository.save(administrador);
        return mapToAdministradorResponseDTO(updateAdministrador);
    }

    public void delete(Long id) {
        Administrador cuenta = administradorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("El administrador con ID " + id + " no fue encontrada")
        );
        administradorRepository.delete(cuenta);
    }

    private AdministradorResponseDTO mapToAdministradorResponseDTO(Administrador administrador) {
        AdministradorResponseDTO responseDTO = new AdministradorResponseDTO();
        responseDTO.setId(administrador.getId());
        responseDTO.setPrecio(administrador.getPrecio());
        responseDTO.setPrecioEspecial(administrador.getPrecioEspecial());
        responseDTO.setFecha(administrador.getFecha());
        return responseDTO;
    }
}