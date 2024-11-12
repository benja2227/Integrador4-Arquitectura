package org.example.micromantenimiento.controllers;

import org.example.micromantenimiento.DTO.MantenimientoRequestDTO;
import org.example.micromantenimiento.DTO.MantenimientoResponseDTO;
import org.example.micromantenimiento.services.MantenimientoService;

import org.example.micromantenimiento.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;



        @GetMapping("")
        public ResponseEntity<List<MantenimientoResponseDTO>> findAll() {
            return ResponseEntity.ok(mantenimientoService.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<MantenimientoResponseDTO> findById(@PathVariable Long id) {
            try {
                return ResponseEntity.ok(mantenimientoService.findById(id));
            } catch (NotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("")
        public ResponseEntity<MantenimientoResponseDTO> save(@RequestBody MantenimientoRequestDTO mantenimientoRequestDTO) {
            MantenimientoResponseDTO newMantenimiento = mantenimientoService.save(mantenimientoRequestDTO);
            return ResponseEntity.ok(newMantenimiento);
        }

        @PutMapping("/{id}")
        public ResponseEntity<MantenimientoResponseDTO> update(@PathVariable Long id, @RequestBody MantenimientoRequestDTO mantenimientoRequestDTO) {
            try {
                return ResponseEntity.ok(mantenimientoService.update(id, mantenimientoRequestDTO));
            } catch (NotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            try {
                mantenimientoService.delete(id);
                return ResponseEntity.noContent().build();
            } catch (NotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }
    }

