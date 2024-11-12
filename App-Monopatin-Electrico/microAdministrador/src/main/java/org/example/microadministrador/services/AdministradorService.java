package org.example.microadministrador.services;



import jakarta.transaction.Transactional;
import org.example.microadministrador.DTO.AdministradorResponseDTO;
import org.example.microadministrador.DTO.AdministradorRequestDTO;
import org.example.microadministrador.entities.Administrador;
import org.example.microadministrador.repositories.AdministradorRepository;
import org.example.microadministrador.services.exception.FechaNulaException;
import org.example.microadministrador.services.exception.NotFoundException;
import org.example.microadministrador.services.exception.TarifaNoEncontradaException;
import org.example.microadministrador.feignClients.CuentaFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private CuentaFeignClient cuentaFeignClient;

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


    public float getTarifaComun(LocalDateTime fecha){

        if (fecha == null) {
            throw new FechaNulaException();
        }

        Administrador actualizacion = administradorRepository
                .findTopByFechaLessThanEqualOrderByFechaDesc(fecha);

        if (actualizacion == null) {
            throw new TarifaNoEncontradaException();
        }

        return actualizacion.getPrecio();
    }

    public float getTarifaEspecial(LocalDateTime fecha){

        if (fecha == null) {
            throw new FechaNulaException();
        }

        Administrador actualizacion = administradorRepository
                .findTopByFechaLessThanEqualOrderByFechaDesc(fecha);

        if (actualizacion == null) {
            throw new TarifaNoEncontradaException();
        }

        return actualizacion.getPrecioEspecial();
    }



        public void updateEstadoCuenta(Long cuentaId, boolean estado) {
            cuentaFeignClient.updateEstadoCuenta(cuentaId,estado);
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

