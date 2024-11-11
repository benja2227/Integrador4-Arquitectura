package org.example.microviaje.services;

import feign.Client;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.micromonopatin.DTO.MonopatinRequestDTO;
import org.example.micromonopatin.DTO.MonopatinResponseDTO;
import org.example.micromonopatin.entities.Monopatin;
import org.example.micromonopatin.repositories.MonopatinRepository;
import org.example.microviaje.DTO.ViajeRequestDTO;
import org.example.microviaje.DTO.ViajeResponseDTO;
import org.example.microviaje.entities.Viaje;
import org.example.microviaje.repositories.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;
    @Qualifier("feignClient")
    @Autowired
    private Client feignClient;

    public List<ViajeResponseDTO> findAll() {
        List<Viaje> viajes = viajeRepository.findAll();
        return viajes.stream().map(this::mapToViajeResponseDTO).collect(Collectors.toList());
    }

    public ViajeResponseDTO findById(Long id) {
        Viaje viaje = viajeRepository.findById(id).orElse(null);
        return viaje != null ? mapToViajeResponseDTO(viaje) : new ViajeResponseDTO();
    }

    @Transactional
    public ViajeResponseDTO save(ViajeRequestDTO viajeRequestDTO) {
        Viaje viaje = new Viaje();
        viaje.setInicio(viajeRequestDTO.getInicio());
        viaje.setFin(viajeRequestDTO.getFin());
        viaje.setId_usuario(viajeRequestDTO.getId_usuario());
        viaje.setId_monopatin(viajeRequestDTO.getId_monopatin());
        viaje.setPrecioTotal(0);
        viaje.setIncioEnPausa(viajeRequestDTO.getIncioEnPausa());
        viaje.setFinEnPausa(viajeRequestDTO.getFinEnPausa());
        viaje.setLatitudFin(viajeRequestDTO.getLatitudFin());
        viaje.setLongitudFin(viajeRequestDTO.getLongitudFin());
        viaje.setLatitudInicio(viajeRequestDTO.getLatitudInicio());
        viaje.setLongitudInicio(viajeRequestDTO.getLongitudInicio());




        Viaje newViaje = viajeRepository.save(viaje);
        return mapToViajeResponseDTO(newViaje);
    }

    public ViajeResponseDTO update(Long id, ViajeRequestDTO viajeRequestDTO) {
        Viaje viaje = viajeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El viaje con ID " + id + " no fue encontrado")
        );

        if (viajeRequestDTO.getInicio() != null) {
            viaje.setInicio(viajeRequestDTO.getInicio());
        }
        if (viajeRequestDTO.getFin() != null) {
            viaje.setFin(viajeRequestDTO.getFin());
        }
        if (viajeRequestDTO.getId_usuario() != null) {
            viaje.setId_usuario(viajeRequestDTO.getId_usuario());
        }
        if (viajeRequestDTO.getId_monopatin() != null) {
            viaje.setId_monopatin(viajeRequestDTO.getId_monopatin());
        }
        if (viajeRequestDTO.getId_monopatin() != null) {
          viaje.setPrecioTotal(viajeRequestDTO.getPrecioTotal());
        }

        if (viajeRequestDTO.getIncioEnPausa() != null) {
            viaje.setIncioEnPausa(viajeRequestDTO.getIncioEnPausa());
        }
        if (viajeRequestDTO.getFinEnPausa() != null) {
            viaje.setFinEnPausa(viajeRequestDTO.getFinEnPausa());
        }
        if (viajeRequestDTO.getLatitudFin() != null) {
            viaje.setLatitudFin(viajeRequestDTO.getLatitudFin());
        }
        if (viajeRequestDTO.getLongitudFin() != null) {
            viaje.setLongitudFin(viajeRequestDTO.getLongitudFin());
        }
        if (viajeRequestDTO.getLatitudInicio() != null) {
            viaje.setLatitudInicio(viajeRequestDTO.getLatitudInicio());
        }
        if (viajeRequestDTO.getLongitudInicio() != null) {
            viaje.setLongitudInicio(viajeRequestDTO.getLongitudInicio());
        }


        Viaje updatedViaje = viajeRepository.save(viaje);
        return mapToViajeResponseDTO(updatedViaje);
    }

    public void delete(Long id) {
        Viaje viaje = viajeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El viaje con ID " + id + " no fue encontrado")
        );
        viajeRepository.delete(viaje);
    }

/*
    public Double findPrecioById(Long id) {
        Viaje viaje = viajeRepository.findById(id).orElse(null);
        return viaje.getPrecioTotal();
    }


*/

    public ViajeResponseDTO updatePrecio(Long id) {
        Viaje viaje = viajeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El viaje con ID " + id + " no fue encontrado")
        );
        //TIEMPO EN PAUSA
        Duration duracionPausa = Duration.between(viaje.getIncioEnPausa(), viaje.getFinEnPausa());
        long minutosPausa = duracionPausa.toMinutes();

        //TIEMPO DE VIAJE

        Duration duracionViaje = Duration.between(viaje.getInicio(), viaje.getFin());
        long minutosViaje = duracionViaje.toMinutes();


        //DISTANCIA RECORRIDA
        double distanciaRecorrida = calcularDistanciaKilometros(
                viaje.getLatitudInicio(), viaje.getLongitudInicio(),
                viaje.getLatitudFin(), viaje.getLongitudFin()
        );
Float tarifa;
if(minutosPausa>=15){
 tarifa = feignClient.getPrecioEspecial();


}
else{
    tarifa = feignClient.getPrecioNormal();

}
        Float precioActualizado = distanciaRecorrida*tarifal;
        viaje.setPrecioTotal(precioActualizado);
        viajeRepository.save(viaje);
        return  this.mapToViajeResponseDTO(viaje);

    }



    private double calcularDistanciaKilometros(double lat1, double lon1, double lat2, double lon2) {
        final int RADIO_TIERRA = 6371; // Radio de la Tierra en km
        double latDistancia = Math.toRadians(lat2 - lat1);
        double lonDistancia = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistancia / 2) * Math.sin(latDistancia / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistancia / 2) * Math.sin(lonDistancia / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return RADIO_TIERRA * c;
    }





    private ViajeResponseDTO mapToViajeResponseDTO(Viaje viaje) {
        ViajeResponseDTO responseDTO = new ViajeResponseDTO();
        responseDTO.setId(viaje.getId());
        responseDTO.setInicio(viaje.getInicio());
        responseDTO.setFin(viaje.getFin());
        responseDTO.setId_usuario(viaje.getId_usuario());
        responseDTO.setId_monopatin(viaje.getId_monopatin());
        responseDTO.setPrecioTotal(viaje.getPrecioTotal());
        responseDTO.setIncioEnPausa(viaje.getIncioEnPausa());
        responseDTO.setFinEnPausa(viaje.getFinEnPausa());
        responseDTO.setLatitudFin(viaje.getLatitudFin());
        responseDTO.setLongitudFin(viaje.getLongitudFin());
        responseDTO.setLatitudInicio(viaje.getLatitudInicio());
        responseDTO.setLongitudInicio(viaje.getLongitudInicio());

        return responseDTO;
    }
}

