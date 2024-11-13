package org.example.microestacion.services;


import jakarta.transaction.Transactional;
import org.example.microestacion.DTO.EstacionRequestDTO;
import org.example.microestacion.DTO.EstacionResponseDTO;
import org.example.microestacion.entities.Estacion;
import org.example.microestacion.repositories.EstacionRepository;
import org.example.microestacion.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstacionService {

    @Autowired
    private EstacionRepository estacionRepository;

    public List<EstacionResponseDTO> findAll() {
        List<Estacion> estaciones = estacionRepository.findAll();
        return estaciones.stream().map(this::mapToEstacionResponseDTO).collect(Collectors.toList());
    }

    public EstacionResponseDTO findById(Long id) {
        Estacion estacion = estacionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("La estación con ID " + id + " no fue encontrada")
        );
        return mapToEstacionResponseDTO(estacion);
    }

    @Transactional
    public EstacionResponseDTO save(EstacionRequestDTO estacionRequestDTO) {
        Estacion estacion = new Estacion();
        estacion.setLatitud(estacionRequestDTO.getLatitud());
        estacion.setLongitud(estacionRequestDTO.getLongitud());

        Estacion newEstacion = estacionRepository.save(estacion);
        return mapToEstacionResponseDTO(newEstacion);
    }

    public EstacionResponseDTO update(Long id, EstacionRequestDTO estacionRequestDTO) {
        Estacion estacion = estacionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("La estación con ID " + id + " no fue encontrada")
        );

        estacion.setLatitud(estacionRequestDTO.getLatitud());
        estacion.setLongitud(estacionRequestDTO.getLongitud());

        Estacion updatedEstacion = estacionRepository.save(estacion);
        return mapToEstacionResponseDTO(updatedEstacion);
    }

    public void delete(Long id) {
        Estacion estacion = estacionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("La estación con ID " + id + " no fue encontrada")
        );
        estacionRepository.delete(estacion);
    }

    private EstacionResponseDTO mapToEstacionResponseDTO(Estacion estacion) {
        EstacionResponseDTO responseDTO = new EstacionResponseDTO();
        responseDTO.setId(estacion.getId());
        responseDTO.setLatitud(estacion.getLatitud());
        responseDTO.setLongitud(estacion.getLongitud());
        return responseDTO;
    }
}
