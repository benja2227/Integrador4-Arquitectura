package org.example.microadministrador.services;



import jakarta.transaction.Transactional;
import org.example.microadministrador.DTO.*;
import org.example.microadministrador.entities.Administrador;
import org.example.microadministrador.feignClients.FacturacionFeignClient;
import org.example.microadministrador.feignClients.MonopatinFeignClient;
import org.example.microadministrador.feignClients.ViajeFeignClient;
import org.example.microadministrador.repositories.AdministradorRepository;
import org.example.microadministrador.services.exception.FechaNulaException;
import org.example.microadministrador.services.exception.NotFoundException;
import org.example.microadministrador.services.exception.TarifaNoEncontradaException;
import org.example.microadministrador.feignClients.CuentaFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.stream.Collectors;


@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private MonopatinFeignClient monopatinFeignClient;

    @Autowired
    private CuentaFeignClient cuentaFeignClient;

    @Autowired
    private ViajeFeignClient viajeFeignClient;

    @Autowired
    private FacturacionFeignClient facturacionFeignClient;

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
        administrador.setTopeKm(administradorRequestDTO.getTopeKm());

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
        administrador.setTopeKm(administradorRequestDTO.getTopeKm());

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
        responseDTO.setTopeKm(administrador.getTopeKm());
        return responseDTO;
    }



    public List<ReporteMonopatinMantDTO> generarReporteA(Boolean includePausa, Long id) {


        Integer topeKm = this.administradorRepository.findById(id).get().getTopeKm();
        List<MonopatinDTO> monopatines = monopatinFeignClient.findAll();

        return monopatines.stream().map(monopatin -> {

            boolean necesitaMantenimiento = monopatin.getKmParaMantenimiento() >= topeKm;

            if (includePausa) {
                return new ReporteMonopatinMantenimientoConPausaDTO(
                        monopatin.getId(),
                        monopatin.getKmParaMantenimiento(),
                        topeKm,
                        necesitaMantenimiento,
                        monopatin.getTiempoEnPausa()
                );
            } else {
                return new ReporteMonopatinMantenimientoDTO(
                        monopatin.getId(),
                        monopatin.getKmParaMantenimiento(),
                        topeKm,
                        necesitaMantenimiento
                );
            }

        }).collect(Collectors.toList());
    }

    public List<ReporteMonopatinPorCantViajesPorAnioDTO> generarReporteC(int cantViajes, int anio) {
        return this.viajeFeignClient.getMonopatinByCantViajeYAnio(cantViajes,anio);

    }


    public ReporteFacturacionRangoDeMesesDTO generarReporteD(int mesInicio, int mesFinal, int anio) {
        System.out.println("ENTRE AL SERVICEEEE");
        return this.facturacionFeignClient.getFacturacionEntreMesesDeUnAnio(mesInicio, mesFinal, anio);
    }
}
