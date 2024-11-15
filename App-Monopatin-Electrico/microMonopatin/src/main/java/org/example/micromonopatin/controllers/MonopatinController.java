package org.example.micromonopatin.controllers;

import org.example.micromonopatin.DTO.*;
import org.example.micromonopatin.services.MonopatinService;
import org.example.micromonopatin.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/reportes/kilometraje")
    public ResponseEntity<List<ReporteKilometrajeDTO>> obtenerReporteKilometraje() {
        List<ReporteKilometrajeDTO> reporte = monopatinService.obtenerReporteKilometraje();
        if (reporte.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    @GetMapping("/reportes/tiempo-con-pausas")
    public ResponseEntity<List<ReporteTiempoDTO>> obtenerReporteTiempoConPausas() {
        List<ReporteTiempoDTO> reporte = monopatinService.obtenerReporteTiempoConPausas();
        if (reporte.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    @GetMapping("/reportes/tiempo-sin-pausas")
    public ResponseEntity<List<ReporteTiempoDTO>> obtenerReporteTiempoSinPausas() {
        List<ReporteTiempoDTO> reporte = monopatinService.obtenerReporteTiempoSinPausas();
        if (reporte.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    @PutMapping("/id/{id}/mantenimiento/{enMantenimiento}")
    public ResponseEntity<MonopatinResponseDTO> update(@PathVariable Long id, @PathVariable boolean enMantenimiento ) {
        try {
            final var resultado = this.monopatinService.findById(id);
            this.monopatinService.updateMantenimiento(id, enMantenimiento);
            return ResponseEntity.ok(resultado);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estado")
    public ResponseEntity<EstadoDeMonopatinesDTO> obtenerEstadoDeMonopatines() {
        try {
            return ResponseEntity.ok(this.monopatinService.obtenerEstadoDeMonopatines());
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build(); // Devuelve un 404 si no se encuentra la información
        }
    }

    @GetMapping("/monopatines-cercanos/latitud/{latitud}/longitud/{longitud}/rango/{rango}")
    public ResponseEntity<List<ReporteMonopatinesCercanosDTO>> generarReporteDeMonopatinesCercanos(
            @PathVariable double latitud, @PathVariable double longitud, @PathVariable double rango
    ) {
        try {
            return ResponseEntity.ok(monopatinService.getReporteDeMonopatinesCercanos(latitud,longitud,rango));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}