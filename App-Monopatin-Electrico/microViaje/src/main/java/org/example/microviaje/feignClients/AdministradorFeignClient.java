package org.example.microviaje.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;


@FeignClient(name = "microAdministrador", url = "http://localhost:8020/administrador")
public interface AdministradorFeignClient {


    @GetMapping("tarifaComunParaFecha/{fecha}")
    Float getTarifaComun(@PathVariable LocalDateTime fecha);

    @GetMapping("/tarifaEspecialParaFecha/{fecha}")
    Float getTarifaEspecial(@PathVariable LocalDateTime fecha);


}
