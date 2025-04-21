package com.gozhu.service.impl;

import com.gozhu.dto.usuario.UsuarioRequestDTO;
import com.gozhu.dto.usuario.UsuarioResponseDTO;
import com.gozhu.entity.Usuario;
import com.gozhu.mapper.UsuarioMapper;
import com.gozhu.repository.UsuarioRepository;
import com.gozhu.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll().stream().map(usuarioMapper::toDTO).toList();
    }

    public UsuarioResponseDTO guardar(UsuarioRequestDTO requestDTO) {
        if (usuarioRepository.existsByEmail(requestDTO.getEmail())){
            throw new RuntimeException("El email ya está registrado");
        }
        if (usuarioRepository.existsByTelefono(requestDTO.getTelefono())) {
            throw new RuntimeException("El teléfono ya está registrado");
        }
        Usuario usuario = usuarioMapper.toEntity(requestDTO);
        Usuario guardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(guardado);
    }

    public UsuarioResponseDTO obtenerPorId(Long id) {
        return usuarioRepository.findById(id).map(usuarioMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void eliminar(Long id) {
        if(!usuarioRepository.existsById(id)) {
            throw new RuntimeException("No existe usuario con ID : " + id);
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario obtenerEntidadPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
