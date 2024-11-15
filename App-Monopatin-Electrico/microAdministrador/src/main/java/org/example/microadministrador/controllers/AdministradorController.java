package org.example.microadministrador.controllers;

import org.example.microadministrador.services.exception.NotFoundException;
import org.example.microadministrador.DTO.*;
import org.example.microadministrador.services.AdministradorService;
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



    // a) Como encargado de mantenimiento quiero poder generar un reporte de uso de monopatines por
    // kilómetros para establecer si un monopatín requiere de mantenimiento. Este reporte debe poder
    // configurarse para incluir (o no) los tiempos de pausa.

    @GetMapping("/reporteA/{id}")
    public ResponseEntity<List<ReporteMonopatinMantDTO>> generarReporteDeMantenimiento(
            @RequestParam(defaultValue = "false") boolean includePausa,  @PathVariable Long id) {
        try {
            return ResponseEntity.ok(administradorService.generarReporteA(includePausa, id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    //b) Como administrador quiero poder anular cuentas para inhabilitar el uso momentaneo de
    // la misma
    @PutMapping("/idcuenta/{id}/estado/{estado}")
    public ResponseEntity<Void> updateEstadoCuenta(@PathVariable Long id, @PathVariable boolean estado) {
        administradorService.updateEstadoCuenta(id,estado);
        return ResponseEntity.noContent().build();
    }


    // c) Como administrador quiero consultar los monopatines con más de X viajes en un cierto año.
    //@GetMapping("/reporteC/cantViajes/{cant-viajes}/anio/{anio}")

    @GetMapping("/reporteC/cantViajes/{cantViajes}/anio/{anio}")
    public ResponseEntity<List<ReporteMonopatinPorCantViajesPorAnioDTO>> generarReporteDeMantenimiento(
            @PathVariable int cantViajes, @PathVariable int anio) {
        try {
            return ResponseEntity.ok(administradorService.generarReporteC(cantViajes, anio));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    //d) Como administrador quiero consultar el total facturado en un rango de meses de cierto año.

    @GetMapping("/reporteD")
    public ResponseEntity<ReporteFacturacionRangoDeMesesDTO> getFacturacionEntreMesesDeUnAnio(@RequestParam(name = "mesInicio", defaultValue = "1") int mesInicio, @RequestParam(name = "mesFinal", defaultValue = "2") int mesFinal, @RequestParam(name = "anio", defaultValue = "2023") int anio){
         {
            try {
                System.out.println("ENTRE AL CONTROLLER");
                return ResponseEntity.ok(administradorService.generarReporteD(mesInicio, mesFinal, anio));
            } catch (NotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }
    }
}