package org.example.microadministrador.feignClients;


import org.example.microadministrador.DTO.ReporteMonopatinPorCantViajesPorAnioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microviaje", url = "http://localhost:8000/viaje")
public interface ViajeFeignClient {

    @GetMapping("/cantViajes/{cantViajes}/anio/{anio}")
    public List<ReporteMonopatinPorCantViajesPorAnioDTO> getMonopatinByCantViajeYAnio(@PathVariable int cantViajes, @PathVariable int anio);

}