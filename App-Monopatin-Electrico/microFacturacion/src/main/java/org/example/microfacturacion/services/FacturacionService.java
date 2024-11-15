package org.example.microfacturacion.services;



import jakarta.transaction.Transactional;
import org.example.microfacturacion.DTO.FacturacionRequestDTO;
import org.example.microfacturacion.DTO.FacturacionResponseDTO;
import org.example.microfacturacion.DTO.ReporteFacturacionRangoDeMesesDTO;
import org.example.microfacturacion.entities.Facturacion;
import org.example.microfacturacion.repositories.FacturacionRepository;
import org.example.microfacturacion.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturacionService {


    @Autowired
    private FacturacionRepository facturacionRepository;

    public List<FacturacionResponseDTO> findAll() {
        List<Facturacion> facturaciones = facturacionRepository.findAll();
        return facturaciones.stream().map(this::mapToFacturacionResponseDTO).collect(Collectors.toList());
    }

    public FacturacionResponseDTO findById(Long id) {
        Facturacion facturacion = facturacionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("La facturación con ID " + id + " no fue encontrada")
        );
        return mapToFacturacionResponseDTO(facturacion);
    }

    @Transactional
    public FacturacionResponseDTO save(FacturacionRequestDTO facturacionRequestDTO) {
        Facturacion facturacion = new Facturacion();
        facturacion.setId(facturacionRequestDTO.getId());
        facturacion.setLatitud(facturacionRequestDTO.getLatitud());
        facturacion.setLongitud(facturacionRequestDTO.getLongitud());
        facturacion.setPrecioFinal(facturacionRequestDTO.getPrecioFinal());

        Facturacion newFacturacion = facturacionRepository.save(facturacion);
        return mapToFacturacionResponseDTO(newFacturacion);
    }

    public FacturacionResponseDTO update(Long id, FacturacionRequestDTO facturacionRequestDTO) {
        Facturacion facturacion = facturacionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("La facturación con ID " + id + " no fue encontrada")
        );
        facturacion.setId(facturacionRequestDTO.getId());
        facturacion.setLatitud(facturacionRequestDTO.getLatitud());
        facturacion.setLongitud(facturacionRequestDTO.getLongitud());
        facturacion.setPrecioFinal(facturacionRequestDTO.getPrecioFinal());

        Facturacion updatedFacturacion = facturacionRepository.save(facturacion);
        return mapToFacturacionResponseDTO(updatedFacturacion);
    }

    public void delete(Long id) {
        Facturacion facturacion = facturacionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("La facturación con ID " + id + " no fue encontrada")
        );
        facturacionRepository.delete(facturacion);
    }

    private FacturacionResponseDTO mapToFacturacionResponseDTO(Facturacion facturacion) {
        FacturacionResponseDTO responseDTO = new FacturacionResponseDTO();
        responseDTO.setId(facturacion.getId());
        responseDTO.setLatitud(facturacion.getLatitud());
        responseDTO.setLongitud(facturacion.getLongitud());
        responseDTO.setPrecioFinal(facturacion.getPrecioFinal());
        return responseDTO;
    }

    public ReporteFacturacionRangoDeMesesDTO generarReporteDeFacturacion(int mesInicio, int mesFin, int anio) {
        // Verificar los valores que se están pasando
        System.out.println("mesInicio: " + mesInicio + ", mesFin: " + mesFin + ", anio: " + anio);

        Float precio = this.facturacionRepository.generarReporteDeFacturacion(anio, mesInicio, mesFin);
        if(precio == null) {
            precio = 0F;
        }
        // Verificar si el precio es null o tiene valor
        System.out.println("Precio calculado: " + precio);

        return new ReporteFacturacionRangoDeMesesDTO(precio, mesInicio, mesFin, anio);
    }
}