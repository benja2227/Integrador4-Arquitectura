package org.example.microusuario.controllers;

import feign.Response;
import org.example.microusuario.DTO.UsuarioRequestDTO;
import org.example.microusuario.DTO.UsuarioResponseDTO;
import org.example.microusuario.entities.Usuario;
import org.example.microusuario.servicio.UsuarioServicio;
import org.example.microusuario.servicio.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController{
    @Autowired
    private UsuarioServicio usuarioService;


    @GetMapping("")
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        return ResponseEntity.ok(this.usuarioService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Long id){
      try {
          return ResponseEntity.ok(this.usuarioService.findById(id));
      }
      catch(NotFoundException e){
          return ResponseEntity.notFound().build();
      }
    }


    @PostMapping("")
    public ResponseEntity<UsuarioResponseDTO> save(@RequestBody UsuarioRequestDTO usuario){
            UsuarioResponseDTO newUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(newUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        try{
            return  ResponseEntity.ok(this.usuarioService.upDateUsuario(id,usuarioRequestDTO));
        }
        catch( NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id){
        try{
            return  ResponseEntity.ok(this.usuarioService.delete(id));
        }
        catch( NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long id) {
        try {
            this.usuarioService.getUsuarioById(id);
            this.usuarioService.deleteUsuarioiById(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
