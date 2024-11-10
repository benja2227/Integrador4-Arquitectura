package org.example.micromonopatin.services;

import jakarta.transaction.Transactional;
import org.example.micromonopatin.DTO.*;
import org.example.micromonopatin.entities.Monopatin;
import org.example.micromonopatin.repositories.MonopatinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonopatinService{

    @Autowired
    private MonopatinRepository monopatinRepository;

    public List<MonopatinResponseDTO> findAll() {
        List<Monopatin> monopatines = monopatinRepository.findAll();
        return monopatines.stream().map(this::mapToMonopatinResponseDTO).collect(Collectors.toList());
    }

    public MonopatinResponseDTO findById(Long id) {
        Monopatin monopatin = monopatinRepository.findById(id).orElse(null);
        return monopatin != null ? mapToMonopatinResponseDTO(monopatin) : new MonopatinResponseDTO();
    }

    @Transactional
    public MonopatinResponseDTO save(MonopatinRequestDTO monopatinRequestDTO) {
        Monopatin monopatin = new Monopatin();
        monopatin.setKmTotales(monopatinRequestDTO.getKmTotales());
        monopatin.setLatitud(monopatinRequestDTO.getLatitud());
        monopatin.setLongitud(monopatinRequestDTO.getLongitud());
        monopatin.setTiempoEnPausa(monopatinRequestDTO.getTiempoEnPausa());
        monopatin.setEnMantenimiento(monopatinRequestDTO.isEnMantenimiento());

        Monopatin newMonopatin = monopatinRepository.save(monopatin);
        return mapToMonopatinResponseDTO(newMonopatin);
    }

    public MonopatinResponseDTO update(Long id, MonopatinRequestDTO monopatinRequestDTO) {
        Monopatin monopatin = monopatinRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El monopatín con ID " + id + " no fue encontrado")
        );

        if (monopatinRequestDTO.getKmTotales() != 0) {
            monopatin.setKmTotales(monopatinRequestDTO.getKmTotales());
        }
        if (monopatinRequestDTO.getLatitud() != null) {
            monopatin.setLatitud(monopatinRequestDTO.getLatitud());
        }
        if (monopatinRequestDTO.getLongitud() != null) {
            monopatin.setLongitud(monopatinRequestDTO.getLongitud());
        }
        if (monopatinRequestDTO.getTiempoEnPausa() != 0) {
            monopatin.setTiempoEnPausa(monopatinRequestDTO.getTiempoEnPausa());
        }
        monopatin.setEnMantenimiento(monopatinRequestDTO.isEnMantenimiento());

        Monopatin updatedMonopatin = monopatinRepository.save(monopatin);
        return mapToMonopatinResponseDTO(updatedMonopatin);
    }

    public void delete(Long id) {
        Monopatin monopatin = monopatinRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El monopatín con ID " + id + " no fue encontrado")
        );
        monopatinRepository.delete(monopatin);
    }

    private MonopatinResponseDTO mapToMonopatinResponseDTO(Monopatin monopatin) {
        MonopatinResponseDTO responseDTO = new MonopatinResponseDTO();
        responseDTO.setKmTotales(monopatin.getKmTotales());
        responseDTO.setLatitud(monopatin.getLatitud());
        responseDTO.setLongitud(monopatin.getLongitud());
        responseDTO.setTiempoEnPausa(monopatin.getTiempoEnPausa());
        responseDTO.setEnMantenimiento(monopatin.isEnMantenimiento());
        return responseDTO;
    }

    public List<ReporteKilometrajeDTO> obtenerReporteKilometraje() {
        List<Object[]> result = monopatinRepository.reporteKilometraje();
        return result.stream()
                .map(obj -> new ReporteKilometrajeDTO((Long) obj[0], (Long) obj[1]))
                .collect(Collectors.toList());
    }

    public List<ReporteTiempoConPausaDTO> obtenerReporteTiempoConPausas() {
        List<Object[]> result = monopatinRepository.reporteTiempoConPausas();
        return result.stream()
                .map(obj -> new ReporteTiempoConPausaDTO((Long) obj[0], (Long) obj[1]))
                .collect(Collectors.toList());
    }

    public List<ReporteTiempoSinPausaDTO> obtenerReporteTiempoSinPausas() {
        List<Object[]> result = monopatinRepository.reporteTiempoSinPausas();
        return result.stream()
                .map(obj -> new ReporteTiempoSinPausaDTO((Long) obj[0], (Long) obj[1]))
                .collect(Collectors.toList());
    }
}
