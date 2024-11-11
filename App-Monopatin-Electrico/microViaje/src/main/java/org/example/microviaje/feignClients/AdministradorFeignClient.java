package org.example.microviaje.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "microAdministrador", url = "http://localhost:8020/administrador")
public interface AdministradorFeignClient {


    @GetMapping("/tarifaConPausa}")
    Float getTarifaConPausa();

    @GetMapping("/tarifaSinPausa}")
    Float getTarifaSinPausa();

}
