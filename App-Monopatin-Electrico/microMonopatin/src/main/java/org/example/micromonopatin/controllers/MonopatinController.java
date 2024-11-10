package org.example.micromonopatin.controllers;

import org.example.micromonopatin.DTO.MonopatinRequestDTO;
import org.example.micromonopatin.DTO.MonopatinResponseDTO;
import org.example.micromonopatin.services.MonopatinService;
import org.example.micromonopatin.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/monopatin")
public class MonopatinController {
    @Autowired
    private MonopatinService monopatinService;

    @GetMapping("")
    public ResponseEntity<List<MonopatinResponseDTO>> findAll() {
        return ResponseEntity.ok(this.monopatinService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonopatinResponseDTO> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.monopatinService.findById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<MonopatinResponseDTO> save(@RequestBody MonopatinRequestDTO monopatin) {
        MonopatinResponseDTO newMonopatin = monopatinService.save(monopatin);
        return ResponseEntity.ok(newMonopatin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonopatinResponseDTO> update(@PathVariable Long id, @RequestBody MonopatinRequestDTO monopatinRequestDTO) {
        try {
            return ResponseEntity.ok(this.monopatinService.update(id, monopatinRequestDTO));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            this.monopatinService.findById(id);
            this.monopatinService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
