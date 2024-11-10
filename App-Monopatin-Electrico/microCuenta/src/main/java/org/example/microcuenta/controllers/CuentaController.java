package org.example.microcuenta.controllers;


import org.example.microcuenta.DTO.CuentaRequestDTO;
import org.example.microcuenta.DTO.CuentaResponseDTO;
import org.example.microcuenta.services.CuentaServicio;
import org.example.microcuenta.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaServicio cuentaService;

    @GetMapping("")
    public ResponseEntity<List<CuentaResponseDTO>> findAll() {
        return ResponseEntity.ok(cuentaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaResponseDTO> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(cuentaService.findById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<CuentaResponseDTO> save(@RequestBody CuentaRequestDTO cuentaRequestDTO) {
        CuentaResponseDTO newCuenta = cuentaService.save(cuentaRequestDTO);
        return ResponseEntity.ok(newCuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaResponseDTO> update(@PathVariable Long id, @RequestBody CuentaRequestDTO cuentaRequestDTO) {
        try {
            return ResponseEntity.ok(cuentaService.update(id, cuentaRequestDTO));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            cuentaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}