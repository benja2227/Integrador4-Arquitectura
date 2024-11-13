package org.example.micromonopatin.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "micromantenimiento", url = "http://localhost:8020/mantenimiento")
public interface MantenimientoFeignClient {

 //   @GetMapping("/byCuenta/{id}")
  //  List<Usuario> getUsuariosPorId(@PathVariable("id") Long id);

}
