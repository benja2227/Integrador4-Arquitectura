package org.example.microcuenta.services;



import jakarta.transaction.Transactional;
import org.example.microcuenta.DTO.CuentaRequestDTO;
import org.example.microcuenta.DTO.CuentaResponseDTO;
import org.example.microcuenta.entities.Cuenta;
import org.example.microcuenta.feignClients.UsuarioFeignClient;
import org.example.microcuenta.repositories.CuentaRepository;
import org.example.microcuenta.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private UsuarioFeignClient usuarioFeignClient;

    public List<CuentaResponseDTO> findAll() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        return cuentas.stream().map(this::mapToCuentaResponseDTO).collect(Collectors.toList());
    }

    public CuentaResponseDTO findById(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("La cuenta con ID " + id + " no fue encontrada")
        );
        return mapToCuentaResponseDTO(cuenta);
    }

    @Transactional
    public CuentaResponseDTO save(CuentaRequestDTO cuentaRequestDTO) {
        Cuenta cuenta = new Cuenta();
        cuenta.setId_usuario(cuentaRequestDTO.getId_usuario());
        cuenta.setFechaAlta(cuentaRequestDTO.getFechaAlta());
        cuenta.setSaldo(cuentaRequestDTO.getSaldo());

        Cuenta newCuenta = cuentaRepository.save(cuenta);
        return mapToCuentaResponseDTO(newCuenta);
    }

    public CuentaResponseDTO update(Long id, CuentaRequestDTO cuentaRequestDTO) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("La cuenta con ID " + id + " no fue encontrada")
        );

        cuenta.setId_usuario(cuentaRequestDTO.getId_usuario());
        cuenta.setFechaAlta(cuentaRequestDTO.getFechaAlta());
        cuenta.setSaldo(cuentaRequestDTO.getSaldo());

        Cuenta updatedCuenta = cuentaRepository.save(cuenta);
        return mapToCuentaResponseDTO(updatedCuenta);
    }

    public void delete(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("La cuenta con ID " + id + " no fue encontrada")
        );
        cuentaRepository.delete(cuenta);
    }

    private CuentaResponseDTO mapToCuentaResponseDTO(Cuenta cuenta) {
        CuentaResponseDTO responseDTO = new CuentaResponseDTO();
        responseDTO.setId(cuenta.getId());
        responseDTO.setId_usuario(cuenta.getId_usuario());
        responseDTO.setFechaAlta(cuenta.getFechaAlta());
        responseDTO.setSaldo(cuenta.getSaldo());
        return responseDTO;
    }

    public List<CuentaResponseDTO> getCuentasPorIdUsuario(Long idUsuario) {
        List<Cuenta> cuentas = cuentaRepository.findByIdUsuario(idUsuario);
        return cuentas.stream().map(this::mapToCuentaResponseDTO).collect(Collectors.toList());

    }


    public CuentaResponseDTO updateEstadoCuenta(Long id, boolean activa){
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("La cuenta con ID " + id + " no fue encontrada")
        );
        System.out.println("ENTREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        cuenta.setActiva(activa);
        System.out.println(cuenta);
        cuentaRepository.save(cuenta);
        return mapToCuentaResponseDTO(cuenta);
    }

}
