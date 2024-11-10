package org.example.microviaje.services;

import jakarta.transaction.Transactional;
import org.example.micromonopatin.DTO.MonopatinRequestDTO;
import org.example.micromonopatin.DTO.MonopatinResponseDTO;
import org.example.micromonopatin.entities.Monopatin;
import org.example.micromonopatin.repositories.MonopatinRepository;
import org.example.microviaje.DTO.ViajeRequestDTO;
import org.example.microviaje.DTO.ViajeResponseDTO;
import org.example.microviaje.entities.Viaje;
import org.example.microviaje.repositories.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    public List<ViajeResponseDTO> findAll() {
        List<Viaje> viajes = viajeRepository.findAll();
        return viajes.stream().map(this::mapToViajeResponseDTO).collect(Collectors.toList());
    }

    public ViajeResponseDTO findById(Long id) {
        Viaje viaje = viajeRepository.findById(id).orElse(null);
        return viaje != null ? mapToViajeResponseDTO(viaje) : new ViajeResponseDTO();
    }

    @Transactional
    public ViajeResponseDTO save(ViajeRequestDTO viajeRequestDTO) {
        Viaje viaje = new Viaje();
        viaje.setInicio(viajeRequestDTO.getInicio());
        viaje.setFin(viajeRequestDTO.getFin());
        viaje.setUsuario(viajeRequestDTO.getUsuario());
        viaje.setMonopatin(viajeRequestDTO.getMonopatin());
        viaje.setKmRecorridos(viajeRequestDTO.getKmRecorridos());

        Viaje newViaje = viajeRepository.save(viaje);
        return mapToViajeResponseDTO(newViaje);
    }

    public ViajeResponseDTO update(Long id, ViajeRequestDTO viajeRequestDTO) {
        Viaje viaje = viajeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El viaje con ID " + id + " no fue encontrado")
        );

        if (viajeRequestDTO.getInicio() != null) {
            viaje.setInicio(viajeRequestDTO.getInicio());
        }
        if (viajeRequestDTO.getFin() != null) {
            viaje.setFin(viajeRequestDTO.getFin() );
        }
        if (viajeRequestDTO.getUsuario() != null) {
            viaje.setUsuario(viajeRequestDTO.getUsuario());
        }
        if (viajeRequestDTO.getMonopatin() != null) {
            viaje.setMonopatin(viajeRequestDTO.getMonopatin());
        }
        if (viajeRequestDTO.getKmRecorridos() < 0) {
            viaje.setKmRecorridos(viajeRequestDTO.getKmRecorridos());
        }

        Viaje updatedViaje = viajeRepository.save(viaje);
        return mapToViajeResponseDTO(updatedViaje);
    }

    public void delete(Long id) {
        Viaje viaje = viajeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El viaje con ID " + id + " no fue encontrado")
        );
        viajeRepository.delete(viaje);
    }

    //HACER DTO
    private ViajeResponseDTO mapToViajeResponseDTO(Viaje viaje) {
        ViajeResponseDTO responseDTO = new ViajeResponseDTO();
        responseDTO.setInicio(viaje.getInicio());
        responseDTO.setFin(viaje.getFin());
        responseDTO.setUsuario(viaje.getUsuario());
        responseDTO.setMonopatin(viaje.getMonopatin());
        responseDTO.setKmRecorridos(viaje.getKmRecorridos());
        return responseDTO;
    }
}
