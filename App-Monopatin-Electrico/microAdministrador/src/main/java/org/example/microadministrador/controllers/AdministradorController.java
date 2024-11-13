package org.example.microadministrador.controllers;


import org.example.microadministrador.DTO.*;
import org.example.microadministrador.services.AdministradorService;
import org.example.microcuenta.DTO.CuentaResponseDTO;
import org.example.microcuenta.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/administrador")
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


    @GetMapping("tarifaComunParaFecha/{fecha}")
    public ResponseEntity<Float> getTarifaComun(@PathVariable LocalDateTime fecha) {
        return ResponseEntity.ok(administradorService.getTarifaComun(fecha));
    }

    @GetMapping("tarifaEspecialParaFecha/{fecha}")
    public ResponseEntity<Float> getTarifaEspecial(@PathVariable LocalDateTime fecha){
        return ResponseEntity.ok(administradorService.getTarifaEspecial(fecha));
    }


    @PutMapping("/idcuenta/{id}/estado/{boolean}")
    public ResponseEntity<Void> updateEstadoCuenta(@PathVariable Long id, @PathVariable boolean estado) {
        administradorService.updateEstadoCuenta(id,estado);
        return ResponseEntity.noContent().build();
    }

    // a) Como encargado de mantenimiento quiero poder generar un reporte de uso de monopatines por
    // kilómetros para establecer si un monopatín requiere de mantenimiento. Este reporte debe poder
    // configurarse para incluir (o no) los tiempos de pausa.

    // Con Pausa: GET /administrador/reporteA?includePausa=true
    // Sin Pausa: GET /administrador/reporteA?includePausa=false
    @GetMapping("/reporteA")
    public ResponseEntity<List<ReporteMonopatinMantDTO>> generarReporteDeMantenimiento(
            @RequestParam(defaultValue = "false") boolean includePausa
    ) {
        try {
            return ResponseEntity.ok(administradorService.generarReporteA(includePausa));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // c) Como administrador quiero consultar los monopatines con más de X viajes en un cierto año.
    //@GetMapping("/reporteC/cantViajes/{cant-viajes}/anio/{anio}")
    @GetMapping("/reporteC/{cantViajes}/{anio}")
    public ResponseEntity<List<ReporteMonopatinMantenimientoDTO>> generarReporteDeMantenimiento(
            @PathVariable int cantViajes, @PathVariable int anio
    ) {
        try {
            return ResponseEntity.ok(administradorService.generarReporteC(cantViajes, anio));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @
    public List<MonopatinDTO> obtenerMonopatines() {
        return administradorService.obtenerMonopatines();
    }



}