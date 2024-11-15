package org.example.microadministrador.feignClients;

import org.example.microadministrador.DTO.FacturacionParamDTO;
import org.example.microadministrador.DTO.ReporteFacturacionRangoDeMesesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="microfacturacion", url="http://localhost:8040/facturacion")
public interface FacturacionFeignClient {
    @GetMapping("/facturacionEntreFechas")
    ReporteFacturacionRangoDeMesesDTO getFacturacionEntreMesesDeUnAnio(@RequestParam(name = "mesInicio", defaultValue = "1") int mesInicio, @RequestParam(name = "mesFinal", defaultValue = "2") int mesFinal, @RequestParam(name = "anio", defaultValue = "2023") int anio);

}