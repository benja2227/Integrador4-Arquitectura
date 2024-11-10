package org.example.microusuario.feignClients;



import org.example.microcuenta.DTO.CuentaResponseDTO;
import org.example.microcuenta.entities.Cuenta;
import org.example.microusuario.entities.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

    @FeignClient(name="microcuenta", url="http://localhost:8060/cuenta")
    public interface CuentaFeignClient {

        @GetMapping("/byCuenta/{id}")
        List<CuentaResponseDTO> getCuentasPorIdUsuario(@PathVariable("id") Long id);



    }

