package org.example.microadministrador.feignClients;

import org.example.microadministrador.DTO.MonopatinDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "micromonopatin", url = "http://localhost:8060/monopatin")
public interface MonopatinFeignClient {

    @GetMapping("")
    List<MonopatinDTO> findAll();
}