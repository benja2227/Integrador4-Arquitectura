package org.example.microadministrador.feignClients;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name="microusuario", url="http://localhost:8010/administrador")
public interface AdministradorFeignClient {

}
