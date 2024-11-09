package org.example.microusuario.controllers;

import org.example.microusuario.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController{
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        Usuario newUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(newUsuario);
    }
}
