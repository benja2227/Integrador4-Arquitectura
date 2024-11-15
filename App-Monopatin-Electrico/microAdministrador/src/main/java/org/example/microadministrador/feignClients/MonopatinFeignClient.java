package org.example.microadministrador.feignClients;

import org.example.microadministrador.DTO.MonopatinDTO;
import org.example.micromonopatin.DTO.EstadoDeMonopatinesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "micromonopatin", url = "http://localhost:8020/monopatin")
public interface MonopatinFeignClient {

    @GetMapping("")
    List<MonopatinDTO> findAll();

    @GetMapping("/estado")
    EstadoDeMonopatinesDTO getEstadoDeMonopatines();
}