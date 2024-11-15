package org.example.microviaje.controllers;



import org.example.microviaje.DTO.ReporteMonopatinPorCantViajesPorAnioDTO;
import org.example.microviaje.DTO.ViajeRequestDTO;
import org.example.microviaje.DTO.ViajeResponseDTO;
import org.example.microviaje.services.ViajeService;
import org.example.microviaje.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaje")
public class ViajeController {
    @Autowired
    private ViajeService viajeService;


    @GetMapping("")
    public ResponseEntity<List<ViajeResponseDTO>> findAll() {
        return ResponseEntity.ok(this.viajeService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ViajeResponseDTO> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(this.viajeService.findById(id));
        }
        catch(NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("")
    public ResponseEntity<ViajeResponseDTO> save(@RequestBody ViajeRequestDTO viaje){
        ViajeResponseDTO newUsuario = viajeService.save(viaje);
        return ResponseEntity.ok(newUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViajeResponseDTO> update(@PathVariable Long id, @RequestBody ViajeRequestDTO viajeRequestDTO){
        try{
            return ResponseEntity.ok( this.viajeService.update(id, viajeRequestDTO));
        }
        catch( NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            this.viajeService.findById(id);
            this.viajeService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

/*
    @GetMapping("/precio/{idviaje}")
    public ResponseEntity<Double> findPrecioById(@PathVariable Long idviaje){
        try{
            return ResponseEntity.ok(this.viajeService.findPrecioById(idviaje));
        }
        catch( NotFoundException e){
            return ResponseEntity.notFound().build();
        }


    }

    @PutMapping("/precio/{idviaje}")
    public ResponseEntity<Float> findPrecioById(@PathVariable Long idviaje){
        try{
            return ResponseEntity.ok(this.viajeService.updatePrecioById(idviaje));
        }
        catch( NotFoundException e){
            return ResponseEntity.notFound().build();
        }


    }
    @PostMapping("/precio/{idviaje}")
    public ResponseEntity<Float> findPrecioById(@PathVariable Long idviaje){
        try{
            return ResponseEntity.ok(this.viajeService.savePrecioById(idviaje));
        }
        catch( NotFoundException e){
            return ResponseEntity.notFound().build();
        }


    }
    */


    @PutMapping("/determinarPrecio/{idViaje}")
    public ResponseEntity<ViajeResponseDTO> updatePrecio(@PathVariable("idViaje") Long idviaje){
        try {
            return ResponseEntity.ok(viajeService.updatePrecio(idviaje));
        }
        catch(NotFoundException e){
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/cantViajes/{cantViajes}/anio/{anio}")
    public ResponseEntity<List<ReporteMonopatinPorCantViajesPorAnioDTO>> getMonopatinByCantViajeYAnio(@PathVariable int cantViajes, @PathVariable int anio){
        try {
            return ResponseEntity.ok(this.viajeService.getMonopatinByCantViajeYAnio(cantViajes, anio));
        }
        catch(NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
