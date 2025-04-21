package com.gozhu.mapper;

import com.gozhu.dto.usuario.UsuarioRequestDTO;
import com.gozhu.dto.usuario.UsuarioResponseDTO;
import com.gozhu.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioResponseDTO toDTO(Usuario usuario) {
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nombreCompleto(usuario.getNombreCompleto())
                .email(usuario.getEmail())
                .telefono(usuario.getTelefono())
                .build();
    }

    public Usuario toEntity(UsuarioRequestDTO requestDTO) {
        return Usuario.builder()
                .nombreCompleto(requestDTO.getNombreCompleto())
                .email(requestDTO.getEmail())
                .telefono(requestDTO.getTelefono())
                .build();
    }
}
