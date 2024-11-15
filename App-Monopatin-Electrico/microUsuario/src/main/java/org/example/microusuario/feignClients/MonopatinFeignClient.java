package org.example.microusuario.feignClients;

import org.example.microusuario.DTO.ReporteMonopatinesCercanosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "micromonopatin", url = "http://localhost:8020/monopatin")
public interface MonopatinFeignClient {

    @GetMapping("/monopatines-cercanos/latitud/{latitud}/longitud/{longitud}/rango/{rango}")
    List<ReporteMonopatinesCercanosDTO> getReporteDeMonopatinesCercanos(
            @PathVariable("latitud") double latitud, @PathVariable("longitud") double longitud, @PathVariable("rango") double rango);
    }