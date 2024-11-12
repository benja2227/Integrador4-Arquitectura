package org.example.microadministrador.feignClients;

import org.example.microcuenta.DTO.CuentaResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name="microcuenta", url="http://localhost:8060/cuenta")
public interface CuentaFeignClient {
    @PutMapping("/anular/{id}")
    ResponseEntity<Void> anularCuenta(@PathVariable("id") Long id);
}





