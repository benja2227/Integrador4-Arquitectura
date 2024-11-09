package org.example.microcuenta.services;

import org.example.microcuenta.feignClients.UsuarioFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioFeignClient usuarioFeignClient;

    //MIRAR CLASE PARA SEGUIR CON LA IMPLEMENTACION DEL POST EN SERVICE Y REPOSITORY.
    
}
