package org.example.microfacturacion.data;

import org.example.microfacturacion.entities.Facturacion;
import org.example.microfacturacion.repositories.FacturacionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final FacturacionRepository facturacionRepository;

    public DataLoader(FacturacionRepository facturacionRepository) {
        this.facturacionRepository = facturacionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Cargar datos iniciales
        Facturacion factura1 = new Facturacion(null, 40543212L, -38312415L, 250.75f);
        Facturacion factura2 = new Facturacion(null, 40353454L, -38123876L, 450.50f);

        facturacionRepository.save(factura1);
        facturacionRepository.save(factura2);

        System.out.println("Datos iniciales cargados en la base de datos para microFacturacion.");
    }
}