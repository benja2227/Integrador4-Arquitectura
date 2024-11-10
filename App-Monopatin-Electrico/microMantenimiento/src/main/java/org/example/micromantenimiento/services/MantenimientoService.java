package org.example.micromantenimiento.services;


import jakarta.transaction.Transactional;
import org.example.micromantenimiento.DTO.MantenimientoRequestDTO;
import org.example.micromantenimiento.DTO.MantenimientoResponseDTO;
import org.example.micromantenimiento.entities.Mantenimiento;
import org.example.micromantenimiento.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MantenimientoServicio {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    public List<MantenimientoResponseDTO> findAll() {
        List<Mantenimiento> mantenimientos = mantenimientoRepository.findAll();
        return mantenimientos.stream().map(this::mapToMantenimientoResponseDTO).collect(Collectors.toList());
    }

    public MantenimientoResponseDTO findById(Long id) {
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("El mantenimiento con ID " + id + " no fue encontrado")
        );
        return mapToMantenimientoResponseDTO(mantenimiento);
    }

    @Transactional
    public MantenimientoResponseDTO save(MantenimientoRequestDTO mantenimientoRequestDTO) {
        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setIDmonopatin(mantenimientoRequestDTO.getIDmonopatin());
        mantenimiento.setFechaMantenimiento(mantenimientoRequestDTO.getFechaMantenimiento());
        mantenimiento.setTopeKm(mantenimientoRequestDTO.getTopeKm());

        Mantenimiento newMantenimiento = mantenimientoRepository.save(mantenimiento);
        return mapToMantenimientoResponseDTO(newMantenimiento);
    }

    public MantenimientoResponseDTO update(Long id, MantenimientoRequestDTO mantenimientoRequestDTO) {
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("El mantenimiento con ID " + id + " no fue encontrado")
        );

        mantenimiento.setIDmonopatin(mantenimientoRequestDTO.getIDmonopatin());
        mantenimiento.setFechaMantenimiento(mantenimientoRequestDTO.getFechaMantenimiento());
        mantenimiento.setTopeKm(mantenimientoRequestDTO.getTopeKm());

        Mantenimiento updatedMantenimiento = mantenimientoRepository.save(mantenimiento);
        return mapToMantenimientoResponseDTO(updatedMantenimiento);
    }

    public void delete(Long id) {
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("El mantenimiento con ID " + id + " no fue encontrado")
        );
        mantenimientoRepository.delete(mantenimiento);
    }

    private MantenimientoResponseDTO mapToMantenimientoResponseDTO(Mantenimiento mantenimiento) {
        MantenimientoResponseDTO responseDTO = new MantenimientoResponseDTO();
        responseDTO.setIDmonopatin(mantenimiento.getIDmonopatin());
        responseDTO.setFechaMantenimiento(mantenimiento.getFechaMantenimiento());
        responseDTO.setTopeKm(mantenimiento.getTopeKm());
        return responseDTO;
    }
}
