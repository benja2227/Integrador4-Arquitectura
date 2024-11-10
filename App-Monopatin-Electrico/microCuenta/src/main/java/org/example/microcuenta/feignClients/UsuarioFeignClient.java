package org.example.microcuenta.feignClients;

import org.example.microusuario.entities.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="microusuario", url="http://localhost:8020/usuario")
public interface UsuarioFeignClient {

    @GetMapping("/byCuenta/{id}")
    List<Usuario> getUsuariosPorId(@PathVariable("id") Long id);

    @PostMapping
    Usuario save(@RequestBody Usuario usuario);


}
