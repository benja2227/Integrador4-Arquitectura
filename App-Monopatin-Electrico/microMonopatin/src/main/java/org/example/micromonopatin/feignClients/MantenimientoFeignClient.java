package org.example.micromonopatin.feignClients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "micromantenimiento", url = "http://localhost:8020/mantenimiento")
public interface MantenimientoFeignClient {



}
