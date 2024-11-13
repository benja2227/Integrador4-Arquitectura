package org.example.microestacion.controllers;


import org.example.microestacion.DTO.EstacionRequestDTO;
import org.example.microestacion.DTO.EstacionResponseDTO;
import org.example.microestacion.services.EstacionService;

import org.example.microestacion.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/estacion")
public class EstacionController {

    @Autowired
    private EstacionService estacionService;

    @GetMapping("")
    public ResponseEntity<List<EstacionResponseDTO>> findAll() {
        return ResponseEntity.ok(estacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacionResponseDTO> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(estacionService.findById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<EstacionResponseDTO> save(@RequestBody EstacionRequestDTO estacionRequestDTO) {
        EstacionResponseDTO newEstacion = estacionService.save(estacionRequestDTO);
        return ResponseEntity.ok(newEstacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstacionResponseDTO> update(@PathVariable Long id, @RequestBody EstacionRequestDTO estacionRequestDTO) {
        try {
            return ResponseEntity.ok(estacionService.update(id, estacionRequestDTO));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            estacionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
