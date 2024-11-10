package org.example.microfacturacion.controllers;


import org.example.microfacturacion.DTO.FacturacionRequestDTO;
import org.example.microfacturacion.DTO.FacturacionResponseDTO;
import org.example.microfacturacion.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionServicio facturacionService;

    @GetMapping("")
    public ResponseEntity<List<FacturacionResponseDTO>> findAll() {
        return ResponseEntity.ok(facturacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturacionResponseDTO> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(facturacionService.findById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<FacturacionResponseDTO> save(@RequestBody FacturacionRequestDTO facturacionRequestDTO) {
        FacturacionResponseDTO newFacturacion = facturacionService.save(facturacionRequestDTO);
        return ResponseEntity.ok(newFacturacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturacionResponseDTO> update(@PathVariable Long id, @RequestBody FacturacionRequestDTO facturacionRequestDTO) {
        try {
            return ResponseEntity.ok(facturacionService.update(id, facturacionRequestDTO));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            facturacionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}