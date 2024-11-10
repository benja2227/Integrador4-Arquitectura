package org.example.microcuenta.feignClients;

import org.example.microcuenta.DTO.CuentaResponseDTO;
import org.example.microcuenta.entities.Cuenta;
import org.example.microusuario.entities.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="microusuario", url="http://localhost:8010/usuario")
public interface UsuarioFeignClient {

    @GetMapping("/byUsuario/{id}")
    List<CuentaResponseDTO> getCuentaPorIdUsuario(@PathVariable("id") Long id);
}
