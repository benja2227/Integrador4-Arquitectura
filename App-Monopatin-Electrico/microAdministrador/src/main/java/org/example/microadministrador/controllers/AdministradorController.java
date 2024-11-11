package org.example.microadministrador.controllers;


import org.example.microadministrador.DTO.AdministradorResponseDTO;
import org.example.microadministrador.DTO.AdministradorRequestDTO;
import org.example.microadministrador.services.AdministradorService;
import org.example.microcuenta.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/Administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("")
    public ResponseEntity<List<AdministradorResponseDTO>> findAll() {
        return ResponseEntity.ok(administradorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorResponseDTO> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(administradorService.findById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<AdministradorResponseDTO> save(@RequestBody AdministradorRequestDTO administradorRequestDTO) {
        AdministradorResponseDTO newAdministrador = administradorService.save(administradorRequestDTO);
        return ResponseEntity.ok(newAdministrador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministradorResponseDTO> update(@PathVariable Long id, @RequestBody AdministradorRequestDTO administradorRequestDTO) {
        try {
            return ResponseEntity.ok(administradorService.update(id, administradorRequestDTO));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            administradorService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}