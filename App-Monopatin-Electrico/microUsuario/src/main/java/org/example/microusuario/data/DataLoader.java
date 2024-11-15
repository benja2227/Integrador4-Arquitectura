package org.example.microusuario.data;

import org.example.microusuario.entities.Usuario;
import org.example.microusuario.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Cargar datos iniciales
        Usuario usuario1 = new Usuario(1L, "Carlos", "Gomez", "carlos.gomez@example.com", "123456789",785340.4, 333111.20);
        Usuario usuario2 = new Usuario(2L, "Ana", "Lopez", "ana.lopez@example.com", "987654321",329856.0, 220343.12);

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        System.out.println("Datos iniciales cargados en la base de datos para microUsuario.");
    }
}