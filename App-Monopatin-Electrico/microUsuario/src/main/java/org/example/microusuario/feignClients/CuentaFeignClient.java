package org.example.microusuario.feignClients;



//import org.example.microcuenta.DTO.CuentaResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

    @FeignClient(name="microcuenta", url="http://localhost:8060/cuenta")
    public interface CuentaFeignClient {
/*
        @GetMapping("/cuentaPorUsuario/{idUsuario}")
        List<CuentaResponseDTO> getCuentasPorIdUsuario(@PathVariable("id") Long id);

*/
        //void updateEstadoCuenta(Long cuentaId, boolean estado);
    }

