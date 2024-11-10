package org.example.microusuario.servicio;

import jakarta.transaction.Transactional;
import org.example.microusuario.DTO.UsuarioRequestDTO;
import org.example.microusuario.DTO.UsuarioResponseDTO;
import org.example.microusuario.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.security.ResourceServerTokenRelayAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioFeignClient usuarioFeignClient;
    @Autowired
    private ResourceServerTokenRelayAutoConfiguration resourceServerTokenRelayAutoConfiguration;

    public List<UsuarioResponseDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(this::mapToUsuarioResponseDTO).collect(Collectors.toList());
    }

    public UsuarioResponseDTO findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    public UsuarioResponseDTO save(UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        Usuario usuario = usuarioFeignClient.findById(usuarioRequestDTO.getId());
        if (usuario == null) {
            usuarioResponseDTO.set

        }
        usuarioRepository.save()
    }




    private UsuarioResponseDTO mapToUsuarioResponseDTO(Usuario usuario) {

        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();

        responseDTO.setNombre(usuario.getNombre());
        responseDTO.setApellido(usuario.getApellido());
        responseDTO.setEmail(usuario.getEmail());
        responseDTO.setTelefono(usuario.getTelefono());

        return responseDTO;
    }

}